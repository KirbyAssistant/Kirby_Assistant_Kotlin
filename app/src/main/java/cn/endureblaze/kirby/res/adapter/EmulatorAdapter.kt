package cn.endureblaze.kirby.res.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import cn.ednureblaze.glidecache.GlideCache
import cn.endureblaze.kirby.Kirby
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.databinding.ItemEmulatorBinding
import cn.endureblaze.kirby.res.dataclass.ResItem
import cn.endureblaze.kirby.utils.ActManager
import com.bumptech.glide.Glide

class EmulatorAdapter(private val emulatorList: List<ResItem>) :
    RecyclerView.Adapter<EmulatorAdapter.ViewHolder>() {

    private var mContext: Context? = null

    inner class ViewHolder(itemEmulatorBinding: ItemEmulatorBinding) :
        RecyclerView.ViewHolder(itemEmulatorBinding.root) {
        val itemEmulator = itemEmulatorBinding.root
        val emulatorImage = itemEmulatorBinding.emulatorImage
        val blurImage = itemEmulatorBinding.blurImage
        val emulatorText = itemEmulatorBinding.emulatorText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mContext == null) {
            mContext = parent.context
        }
        val itemEmulatorBinding = ItemEmulatorBinding.inflate(LayoutInflater.from(mContext), parent, false)
        val holder = ViewHolder(itemEmulatorBinding)
        return holder
    }

    override fun getItemCount() = emulatorList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emulator = emulatorList[position]
        val animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_recycler_item_show)
        val alphaAnimation = AlphaAnimation(0.1f, 1.0f)
        alphaAnimation.duration = 500

        holder.itemEmulator.startAnimation(animation)
        holder.emulatorImage.animation = alphaAnimation
        holder.blurImage.animation = alphaAnimation
        holder.emulatorText.animation = alphaAnimation

        holder.emulatorText.text = emulator.name
        Glide.with(mContext!!)
            .load(emulator.imageUrl)
            .apply(Kirby.getGlideRequestOptions())
            .into(holder.emulatorImage)
        GlideCache.setBlurImageViaGlideCache(ActManager.currentActivity, holder.blurImage, emulator.imageUrl, "8")
    }

}