package cn.endureblaze.kirby.res.gamelist

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.endureblaze.kirby.databinding.ItemGamedataBinding
import cn.endureblaze.kirby.utils.ToastUtil

class GameDownloadAdapter(
    private val context: Context,
    private val gameData: GameData
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder:ViewHolder
        val view: View
        val itemGameDataBinding:ItemGamedataBinding
        if (convertView == null) {
            itemGameDataBinding = ItemGamedataBinding.inflate(LayoutInflater.from(context), parent, false)
            view = itemGameDataBinding.root
            viewHolder = ViewHolder(itemGameDataBinding)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val version = gameData.versionList[position]
        viewHolder.versionTv.text = version

        viewHolder.download.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.data = Uri.parse(gameData.urlList[position])
            context.startActivity(intent)
        }

        return view
    }

    override fun getItem(position: Int): Any = gameData.versionList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = gameData.versionList.size

    inner class ViewHolder(itemGameDataBinding: ItemGamedataBinding) {
        val versionTv = itemGameDataBinding.gameVersion
        val download = itemGameDataBinding.gameDownload
    }
}