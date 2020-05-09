package cn.endureblaze.kirby.ui.video

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import cn.endureblaze.kirby.Kirby
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.databinding.ItemVideoBinding
import cn.endureblaze.kirby.logic.model.Video
import com.bumptech.glide.Glide

class VideoAdapter(private val videoList: List<Video>) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    private var mContext: Context? = null

    inner class ViewHolder(itemVideoBinding: ItemVideoBinding) : RecyclerView.ViewHolder(itemVideoBinding.root) {
        val itemVideo = itemVideoBinding.root
        val linearLayout = itemVideoBinding.LinearLayout
        val videoImage = itemVideoBinding.videoImage
        val videoName = itemVideoBinding.videoText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if(mContext == null){
            mContext = parent.context
        }
        val itemVideoBinding = ItemVideoBinding.inflate(LayoutInflater.from(mContext),parent,false)
        val holder = ViewHolder(itemVideoBinding)
        holder.linearLayout.setOnClickListener {

        }
        return holder
    }

    override fun getItemCount(): Int = videoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_recycler_item_show)
        val alphaAnimation = AlphaAnimation(0.1f, 1.0f)
        alphaAnimation.duration = 500
        val video = videoList[position]

        holder.itemVideo.startAnimation(animation)
        holder.videoName.text = video.name
        mContext?.let {
            Glide
                .with(it)
                .load(video.imageUrl)
                .apply(Kirby.getGlideRequestOptions())
                .into(holder.videoImage)
        }
    }
}