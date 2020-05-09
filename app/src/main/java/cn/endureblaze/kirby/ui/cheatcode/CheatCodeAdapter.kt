package cn.endureblaze.kirby.ui.cheatcode

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.databinding.ItemCheatcodeBinding
import cn.endureblaze.kirby.logic.model.CheatCode
import cn.endureblaze.kirby.utils.ToastUtil

class CheatCodeAdapter(
    private val context: Context,
    private val cheatcodeData: List<CheatCode>
):BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder: ViewHolder
        val view: View
        val itemCheatcodeBinding: ItemCheatcodeBinding
        if(convertView == null){
            itemCheatcodeBinding = ItemCheatcodeBinding.inflate(LayoutInflater.from(context),parent,false)
            view = itemCheatcodeBinding.root
            viewHolder = ViewHolder(itemCheatcodeBinding)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val cheatCode = cheatcodeData[position]
        val name = cheatCode.name
        val cheatcode = cheatCode.cheatcode

        viewHolder.name.text = name
        viewHolder.cheatcode.text = cheatcode

        viewHolder.root.setOnClickListener {
            val cm:ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            cm.setPrimaryClip(ClipData.newPlainText("cheatcode",cheatcode))
            if(cm.hasPrimaryClip()){
                cm.primaryClip?.getItemAt(0)?.text
            }
            ToastUtil.show(R.string.copy_success)
        }
        return view
    }

    override fun getItem(position: Int): Any = cheatcodeData[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = cheatcodeData.size

    inner class ViewHolder(itemCheatcodeBinding: ItemCheatcodeBinding) {
        val root = itemCheatcodeBinding.cheatCodeRootView
        val name = itemCheatcodeBinding.cheatcodeId
        val cheatcode = itemCheatcodeBinding.cheatcodeMess
    }
}