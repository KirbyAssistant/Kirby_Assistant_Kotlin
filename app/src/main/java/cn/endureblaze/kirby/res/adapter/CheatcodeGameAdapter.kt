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
import cn.endureblaze.kirby.databinding.ItemCheatcodeGameBinding
import cn.endureblaze.kirby.res.dataclass.ResItem
import cn.endureblaze.kirby.utils.ActManager
import com.bumptech.glide.Glide

class CheatcodeGameAdapter(private val cheatCodeGameList: List<ResItem>) :
    RecyclerView.Adapter<CheatcodeGameAdapter.ViewHolder>() {

    private var mContext: Context? = null

    inner class ViewHolder(cheatcodeGameBinding: ItemCheatcodeGameBinding) :
        RecyclerView.ViewHolder(cheatcodeGameBinding.root) {
        val itemCheatcodeGame = cheatcodeGameBinding.root
        val cheatcodeImage = cheatcodeGameBinding.cheatcodeImage
        val blurImage = cheatcodeGameBinding.blurImage
        val cheatcodeText = cheatcodeGameBinding.cheatcodeText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mContext == null) {
            mContext = parent.context
        }
        val itemCheatcodeGameBinding = ItemCheatcodeGameBinding.inflate(LayoutInflater.from(mContext), parent, false)
        val holder = ViewHolder(itemCheatcodeGameBinding)

        return holder
    }

    override fun getItemCount() = cheatCodeGameList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cheatcodeGame = cheatCodeGameList[position]
        val animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_recycler_item_show)
        val alphaAnimation = AlphaAnimation(0.1f, 1.0f)
        alphaAnimation.duration = 500

        holder.itemCheatcodeGame.startAnimation(animation)
        holder.cheatcodeImage.animation = alphaAnimation
        holder.blurImage.animation = alphaAnimation
        holder.cheatcodeText.animation = alphaAnimation

        holder.cheatcodeText.text = cheatcodeGame.name
        Glide.with(mContext!!)
            .load(cheatcodeGame.imageUrl)
            .apply(Kirby.getGlideRequestOptions())
            .into(holder.cheatcodeImage)
        GlideCache.setBlurImageViaGlideCache(ActManager.currentActivity, holder.blurImage, cheatcodeGame.imageUrl, "8")

    }

}