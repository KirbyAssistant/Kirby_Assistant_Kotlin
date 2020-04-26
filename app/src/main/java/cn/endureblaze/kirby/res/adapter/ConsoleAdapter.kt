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
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import cn.endureblaze.kirby.Kirby
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.databinding.ItemConsoleBinding
import cn.endureblaze.kirby.res.dataclass.Console
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_console.view.*

class ConsoleAdapter constructor(private val consoleList: List<Console>) :
    RecyclerView.Adapter<ConsoleAdapter.ViewHolder>() {

    private var mContext: Context? = null

    inner class ViewHolder(itemConsoleBinding: ItemConsoleBinding) : RecyclerView.ViewHolder(itemConsoleBinding.root) {
        val itemConsole: View = itemConsoleBinding.root
        val linearLayout: LinearLayout = itemConsole.LinearLayout
        val cardview: CardView = itemConsole.cardview
        val consoleImage: ImageView = itemConsole.console_image
        val consoleName: TextView = itemConsole.console_text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mContext == null) {
            mContext = parent.context
        }
        //val view = LayoutInflater.from(mContext).inflate(R.layout.item_console, parent, false)
        //val holder = ViewHolder(view)
        val itemConsoleBinding = ItemConsoleBinding.inflate(LayoutInflater.from(mContext),parent,false)
        val holder = ViewHolder(itemConsoleBinding)
        holder.linearLayout.setOnClickListener {
            val position = holder.adapterPosition
            val console = consoleList[position]
        }

        return holder
    }

    override fun getItemCount(): Int = consoleList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val console = consoleList[position]

        val animation = AnimationUtils.loadAnimation(mContext,R.anim.anim_recycler_item_show)
        holder.itemConsole.startAnimation(animation)

        val alphaAnimation = AlphaAnimation(0.1f,1.0f)
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