package cn.endureblaze.kirby.res.gamelist

import androidx.lifecycle.ViewModel
import cn.endureblaze.kirby.databinding.ActivityGameListBinding
import cn.endureblaze.kirby.databinding.LayoutToolbarBinding
import cn.endureblaze.kirby.res.dataclass.ResItem

class GameListViewModel : ViewModel() {
    lateinit var binding: ActivityGameListBinding
    lateinit var toolbarBinding: LayoutToolbarBinding

    val gbaGameList = listOf(
        ResItem("星之卡比 梦之泉DX", "https://api.endureblaze.cn/ka_image/game/mengzhiquandx.jpg", "gba_mzqdx"),
        ResItem("星之卡比 镜之大迷宫", "https://api.endureblaze.cn/ka_image/game/jingmi.jpg", "gba_jm")
    )

    val gbGameList = listOf(
        ResItem("星之卡比 1", "https://api.endureblaze.cn/ka_image/game/xing1.jpg", "gb_x1"),
        ResItem("星之卡比 2", "https://api.endureblaze.cn/ka_image/game/xing2.jpg", "gb_x2"),
        ResItem("星之卡比 卡比宝石星", "https://api.endureblaze.cn/ka_image/game/baoshixing.jpg", "gb_bsx"),
        ResItem("星之卡比 卡比打砖块", "https://api.endureblaze.cn/ka_image/game/dazhuankuai.jpg", "gb_dzk"),
        ResItem("星之卡比 卡比弹珠台", "https://api.endureblaze.cn/ka_image/game/danzhutai.jpg", "gb_dzt")
    )

    val sfcGameList = listOf(
        ResItem("星之卡比 3", "https://api.endureblaze.cn/ka_image/game/xing3.jpg", "sfc_x3"),
        ResItem("星之卡比 超豪华版", "https://api.endureblaze.cn/ka_image/game/kss.jpg", "sfc_kss"),
        ResItem("星之卡比 卡比梦幻都", "https://api.endureblaze.cn/ka_image/game/menghuandu.jpg", "sfc_mhd"),
        ResItem("星之卡比 玩具箱合集", "https://api.endureblaze.cn/ka_image/game/toybox.jpg", "sfc_toybox"),
        ResItem("[仅美国]星之卡比 卡比魔方气泡", "https://api.endureblaze.cn/ka_image/game/mofangqipao.jpg", "sfc_mfqp"),
        ResItem("[仅日本]星之卡比 卡比宝石星DX", "https://api.endureblaze.cn/ka_image/game/baoshixingdx.jpg", "sfc_bsxdx")
    )

    val n64GameList = listOf(
        ResItem("星之卡比 64", "https://api.endureblaze.cn/ka_image/game/k64.jpg", "n64_k64")
    )

    val ngcGameList = listOf(
        ResItem("星之卡比 飞天赛车", "https://api.endureblaze.cn/ka_image/game/feitian.jpg", "ngc_ft")
    )

    val wiiGameList = listOf(
        ResItem("星之卡比 触摸卡比", "https://api.endureblaze.cn/ka_image/game/chumo.jpg", "nds_cm"),
        ResItem("星之卡比 超究豪华版", "https://api.endureblaze.cn/ka_image/game/kssu.jpg", "nds_kssu"),
        ResItem("星之卡比 呐喊团", "https://api.endureblaze.cn/ka_image/game/nahantuan.jpg", "nds_nht"),
        ResItem("星之卡比 集合！卡比", "https://api.endureblaze.cn/ka_image/game/jihe.jpg", "nds_jh")
    )

    val fcGameList = listOf(
        ResItem("星之卡比 梦之泉物语", "https://api.endureblaze.cn/ka_image/game/mengzhiquan.jpg", "fc_mzq")
    )
}