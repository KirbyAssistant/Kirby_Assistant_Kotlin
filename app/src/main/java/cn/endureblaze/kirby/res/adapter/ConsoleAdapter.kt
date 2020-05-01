package cn.endureblaze.kirby.res.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.endureblaze.kirby.Kirby
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.databinding.ItemConsoleBinding
import cn.endureblaze.kirby.res.gamelist.GameListActivity
import cn.endureblaze.kirby.res.dataclass.ResItem
import com.bumptech.glide.Glide

class ConsoleAdapter(private val consoleList: List<ResItem>) :
    RecyclerView.Adapter<ConsoleAdapter.ViewHolder>() {

    private var mContext: Context? = null

    inner class ViewHolder(itemConsoleBinding: ItemConsoleBinding) : RecyclerView.ViewHolder(itemConsoleBinding.root) {
        val itemConsole = itemConsoleBinding.root
        val linearLayout = itemConsoleBinding.LinearLayout
        val consoleImage = itemConsoleBinding.consoleImage
        val consoleName = itemConsoleBinding.consoleText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mContext == null) {
            mContext = parent.context
        }
        val itemConsoleBinding = ItemConsoleBinding.inflate(LayoutInflater.from(mContext), parent, false)
        val holder = ViewHolder(itemConsoleBinding)
        holder.linearLayout.setOnClickListener {
            val position = holder.adapterPosition
            val console = consoleList[position]
            mContext?.let { GameListActivity.actionStart(it, console.tag, console.name) }
        }

        return holder
    }

    override fun getItemCount() = consoleList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val console = consoleList[position]

        val animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_recycler_item_show)
        holder.itemConsole.startAnimation(animation)

        val alphaAnimation = AlphaAnimation(0.1f, 1.0f)
        alphaAnimation.duration = 500
        holder.consoleImage.animation = alphaAnimation
        holder.consoleName.animation = alphaAnimation

        holder.consoleName.text = console.name

        Glide.with(mContext!!)
            .load(console.imageUrl)
            .apply(Kirby.getGlideRequestOptions())
            .centerInside()
            .into(holder.consoleImage)

    }
}
