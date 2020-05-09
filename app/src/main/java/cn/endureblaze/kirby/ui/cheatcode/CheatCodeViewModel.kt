package cn.endureblaze.kirby.ui.cheatcode

import androidx.lifecycle.ViewModel
import cn.endureblaze.kirby.databinding.ActivityCheatCodeBinding
import cn.endureblaze.kirby.databinding.LayoutToolbarBinding
import cn.endureblaze.kirby.logic.model.CheatCode

class CheatCodeViewModel : ViewModel() {
    lateinit var binding: ActivityCheatCodeBinding
    lateinit var toolbarBinding: LayoutToolbarBinding

    fun getCheatCodeData(tag: String): List<CheatCode> = when (tag) {
        "gba_jm" -> listOf(
            CheatCode("喷火", "02020FE3 01"),
            CheatCode("冷冻", "02020FE3 02"),
            CheatCode("回力镖", "02020FE3 06"),
            CheatCode("烈焰", "02020FE3 03"),
            CheatCode("轮胎", "02020FE3 04"),
            CheatCode("射线", "02020FE3 07"),
            CheatCode("锤子", "02020FE3 11"),
            CheatCode("石头", "02020FE3 08"),
            CheatCode("炸弹", "02020FE3 09"),
            CheatCode("不明", "02020FE3 0B"),
            CheatCode("厨师", "02020FE3 0C"),
            CheatCode("镭射", "02020FE3 0D"),
            CheatCode("闪电", "02020FE3 0F"),
            CheatCode("旋风", "02020FE3 10"),
            CheatCode("射箭", "02020FE3 13"),
            CheatCode("剑士", "02020FE3 12"),
            CheatCode("格斗", "02020FE3 14"),
            CheatCode("魔术师", "02020FE3 15"),
            CheatCode("万能拳", "02020FE3 16"),
            CheatCode("强力吸收", "02020FE3 0A"),
            CheatCode("雨伞", "02020FE3 05"),
            CheatCode("爆炸", "02020FE3 18"),
            CheatCode("导弹", "02020FE3 19"),
            CheatCode("万能剑", "02020FE3 1A"),
            CheatCode("ufo飞碟", "02020FE3 0E"),
            CheatCode("体力", " 02020FE0 0F "),
            CheatCode("体力上限", "02020FE1 0F"),
            CheatCode("人数", " 02020FE2 63 "),
            CheatCode("电话", " 02020FBC 03 "),
            CheatCode("无敌 ", "02020F3C 06"),
            CheatCode("BOSS一击必杀 ", "02000088 00"),
            CheatCode("镜片全满", " 02038970 FF"),
            CheatCode("传送门全开1", "42028C14 0001"),
            CheatCode("", "0000000F 0004")
        )

        "fc_mzq" -> listOf(
            CheatCode("", "C:05e3:00:01:火炎"),
            CheatCode("", "C:05e3:01:01:火花"),
            CheatCode("", "C:05e3:02:01:回力标"),
            CheatCode("", "C:05e3:03:01:剑"),
            CheatCode("", "C:05e3:04:01:烈焰"),
            CheatCode("", "C:05e3:05:01:镭射"),
            CheatCode("", "C:05e3:06:01:麦克风"),
            CheatCode("", "C:05e3:07:01:车轮"),
            CheatCode("", "C:05e3:08:01:木槌"),
            CheatCode("", "C:05e3:09:01:阳伞"),
            CheatCode("", "C:05e3:0a:01:睡觉"),
            CheatCode("", "C:05e3:0b:01:刺"),
            CheatCode("", "C:05e3:0c:01:冷气"),
            CheatCode("", "C:05e3:0d:01:冻结"),
            CheatCode("", "C:05e3:0e:01:高跳"),
            CheatCode("", "C:05e3:0f:01:射线"),
            CheatCode("", "C:05e3:10:01:岩石"),
            CheatCode("", "C:05e3:11:01:球球"),
            CheatCode("", "C:05e3:12:01:旋风"),
            CheatCode("", "C:05e3:13:01:巨爆"),
            CheatCode("", "C:05e3:14:01:光明"),
            CheatCode("", "C:05e3:15:01:摔角"),
            CheatCode("", "C:05e3:16:01:投掷"),
            CheatCode("", "C:05e3:17:01:UFO"),
            CheatCode("", "C:05e3:18:01:星杖"),
            CheatCode("", "C:05e3:ff:01:锁死为原型"),
            CheatCode("", "C:05e7:02:01:混合"),
            CheatCode("", "C:05e0:0d:01:UFO"),
            CheatCode("", "C:05f9:14:01:无敌")
        )

        "gba_mzqdx" -> listOf(
            CheatCode("开启", "02007D48 63"),
            CheatCode("[生命]", ""),
            CheatCode("开启", "02005588 14"),
            CheatCode("[无敌]", ""),
            CheatCode("开启", "03002182 63"),
            CheatCode("[变身]", ""),
            CheatCode("永远普通的卡比", "0300217D 00"),
            CheatCode("火焰卡比", "0300217D 01"),
            CheatCode("闪电卡比", "0300217D 02"),
            CheatCode("回旋标卡比", "0300217D 03"),
            CheatCode("剑之卡比", "0300217D 04"),
            CheatCode("火焰球卡比", "0300217D 05"),
            CheatCode("激光卡比", "0300217D 06"),
            CheatCode("唱歌卡比", "0300217D 07"),
            CheatCode("车轮卡比", "0300217D 08"),
            CheatCode("锤子卡比", "0300217D 09"),
            CheatCode("雨伞卡比", "0300217D 0A"),
            CheatCode("睡觉卡比", "0300217D 0B"),
            CheatCode("刺猬卡比", "0300217D 0C"),
            CheatCode("冷气卡比", "0300217D 0D"),
            CheatCode("冷冻卡比", "0300217D 0E"),
            CheatCode("超人卡比", "0300217D 0F"),
            CheatCode("射线卡比", "0300217D 10"),
            CheatCode("石头卡比", "0300217D 11"),
            CheatCode("球球卡比", "0300217D 12"),
            CheatCode("旋风卡比", "0300217D 13"),
            CheatCode("巨爆卡比", "0300217D 14"),
            CheatCode("光明卡比", "0300217D 15"),
            CheatCode("摔跤卡比", "0300217D 16"),
            CheatCode("投掷卡比", "0300217D 17"),
            CheatCode("飞碟(UFO)卡比", "0300217D 18"),
            CheatCode("星之卡比星剑士", "0300217D 19"),
            CheatCode("暗夜BUG版1", "0300217D 1A"),
            CheatCode("暗夜BUG版2", "0300217D 1B"),
            CheatCode("[使用唱歌卡比时须补填的内容]", ""),
            CheatCode("3级喇叭", "0300217E 03"),
            CheatCode("2级声波", "0300217E 02"),
            CheatCode("[计时赛时间(秒)]  锁定0", "02270556 00"),
            CheatCode("[计时赛时间(分)]  锁定0", "02270555 00"),
            CheatCode("[计时赛时间(时)]  锁定0", "02270554 00"),
            CheatCode("[无限命数]", ""),
            CheatCode("计时赛,BOSS赛也能", "02261158 63"),
            CheatCode("[无限生命]", ""),
            CheatCode("普通赛", "022CAB28 34"),
            CheatCode("计时赛", "025CAB68 34"),
            CheatCode("BOSS赛", "022CDBE8 34"),
            CheatCode("[无敌金手指修正版（由zhanghm11111修正]", ""),
            CheatCode("", "030021AF 01"),
            CheatCode("", "03002182 01"),
            CheatCode("[无敌金手指（和平模式直接穿过小怪)]", ""),
            CheatCode("", "030021AF 02"),
            CheatCode("", "03002182 01")
        )

        else -> listOf()
    }
}