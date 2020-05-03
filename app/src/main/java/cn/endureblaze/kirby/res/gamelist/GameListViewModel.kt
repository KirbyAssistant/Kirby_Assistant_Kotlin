package cn.endureblaze.kirby.res.gamelist

import androidx.lifecycle.ViewModel
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.databinding.ActivityGameListBinding
import cn.endureblaze.kirby.databinding.LayoutToolbarBinding
import cn.endureblaze.kirby.res.dataclass.ResItem
import cn.endureblaze.kirby.utils.ActManager

class GameListViewModel : ViewModel() {
    lateinit var binding: ActivityGameListBinding
    lateinit var toolbarBinding: LayoutToolbarBinding

    private val jpVersion
        get() = ActManager.currentActivity.getString(R.string.dia_jp)
    private val usVersion
        get() = ActManager.currentActivity.getString(R.string.dia_us)
    private val cnVersion
        get() = ActManager.currentActivity.getString(R.string.dia_cn)

    fun getGameList(tag: String): List<ResItem> = when (tag) {

        "gba" -> listOf(
            ResItem("星之卡比 梦之泉DX", "https://api.endureblaze.cn/ka_image/game/mengzhiquandx.jpg", "gba_mzqdx"),
            ResItem("星之卡比 镜之大迷宫", "https://api.endureblaze.cn/ka_image/game/jingmi.jpg", "gba_jm")
        )

        "gb" -> listOf(
            ResItem("星之卡比 1", "https://api.endureblaze.cn/ka_image/game/xing1.jpg", "gb_x1"),
            ResItem("星之卡比 2", "https://api.endureblaze.cn/ka_image/game/xing2.jpg", "gb_x2"),
            ResItem("星之卡比 卡比宝石星", "https://api.endureblaze.cn/ka_image/game/baoshixing.jpg", "gb_bsx"),
            ResItem("星之卡比 卡比打砖块", "https://api.endureblaze.cn/ka_image/game/dazhuankuai.jpg", "gb_dzk"),
            ResItem("星之卡比 卡比弹珠台", "https://api.endureblaze.cn/ka_image/game/danzhutai.jpg", "gb_dzt")
        )

        "gbc" -> listOf(
            ResItem("星之卡比 滚滚卡比", "https://api.endureblaze.cn/ka_image/game/gungun.jpg", "gbc_gg")
        )

        "sfc" -> listOf(
            ResItem("星之卡比 3", "https://api.endureblaze.cn/ka_image/game/xing3.jpg", "sfc_x3"),
            ResItem("星之卡比 超豪华版", "https://api.endureblaze.cn/ka_image/game/kss.jpg", "sfc_kss"),
            ResItem("星之卡比 卡比梦幻都", "https://api.endureblaze.cn/ka_image/game/menghuandu.jpg", "sfc_mhd"),
            ResItem("星之卡比 玩具箱合集", "https://api.endureblaze.cn/ka_image/game/toybox.jpg", "sfc_toybox"),
            ResItem("[仅美国]星之卡比 卡比魔方气泡", "https://api.endureblaze.cn/ka_image/game/mofangqipao.jpg", "sfc_mfqp"),
            ResItem("[仅日本]星之卡比 卡比宝石星DX", "https://api.endureblaze.cn/ka_image/game/baoshixingdx.jpg", "sfc_bsxdx")
        )

        "n64" -> listOf(
            ResItem("星之卡比 64", "https://api.endureblaze.cn/ka_image/game/k64.jpg", "n64_k64")
        )

        "ngc" -> listOf(
            ResItem("星之卡比 飞天赛车", "https://api.endureblaze.cn/ka_image/game/feitian.jpg", "ngc_ft")
        )

        "nds" -> listOf(
            ResItem("星之卡比 触摸卡比", "https://api.endureblaze.cn/ka_image/game/chumo.jpg", "nds_cm"),
            ResItem("星之卡比 超究豪华版", "https://api.endureblaze.cn/ka_image/game/kssu.jpg", "nds_kssu"),
            ResItem("星之卡比 呐喊团", "https://api.endureblaze.cn/ka_image/game/nahantuan.jpg", "nds_nht"),
            ResItem("星之卡比 集合！卡比", "https://api.endureblaze.cn/ka_image/game/jihe.jpg", "nds_jh")
        )

        "fc" -> listOf(
            ResItem("星之卡比 梦之泉物语", "https://api.endureblaze.cn/ka_image/game/mengzhiquan.jpg", "fc_mzq")
        )

        else -> listOf(
            ResItem("", "", "")
        )
    }

    fun getGameData(tag: String): GameData = when (tag) {
        "gba_mzqdx" -> GameData(
            listOf(jpVersion, usVersion, cnVersion),
            listOf(
                "https://eyun.baidu.com/s/3kURIBIZ",
                "https://eyun.baidu.com/s/3o86TXDS",
                "https://eyun.baidu.com/s/3dF22BWP"
            )
        )

        "gba_jm" -> GameData(
            listOf(jpVersion, usVersion, cnVersion),
            listOf(
                "https://eyun.baidu.com/s/3hs7Mjsg",
                "https://eyun.baidu.com/s/3c5qBl8",
                "https://eyun.baidu.com/s/3i5t6Z3J"
            )
        )

        "sfc_x3" -> GameData(
            listOf(jpVersion, usVersion),
            listOf(
                "https://eyun.baidu.com/s/3pKTD8EZ",
                "https://eyun.baidu.com/s/3gfwui2n"
            )
        )

        "sfc_kss" -> GameData(
            listOf(jpVersion, usVersion),
            listOf(
                "https://eyun.baidu.com/s/3qXEc4Xm",
                "https://eyun.baidu.com/s/3nu8IV"
            )
        )

        "sfc_mhd" -> GameData(
            listOf(jpVersion, usVersion),
            listOf(
                "https://eyun.baidu.com/s/3hsvCjfI",
                "https://eyun.baidu.com/s/3jHCmNps"
            )
        )

        "sfc_toybox" -> GameData(
            listOf(jpVersion),
            listOf("https://eyun.baidu.com/s/3qZr1yry")
        )

        "sfc_mfqp" -> GameData(
            listOf(usVersion),
            listOf("https://eyun.baidu.com/s/3eSuusSi")
        )

        "sfc_bsxdx" -> GameData(
            listOf(jpVersion),
            listOf("https://eyun.baidu.com/s/3kVDhaS3")
        )

        "n64_k64" -> GameData(
            listOf(jpVersion, usVersion),
            listOf(
                "https://eyun.baidu.com/s/3jHPKdMY",
                "https://eyun.baidu.com/s/3jHPKdMY"
            )
        )

        "ngc_ft" -> GameData(
            listOf(usVersion),
            listOf("https://eyun.baidu.com/s/3qYAoXGC")
        )

        "wii_cf" -> GameData(
            listOf(jpVersion, usVersion, cnVersion),
            listOf(
                "https://eyun.baidu.com/s/3skEbla1",
                "https://eyun.baidu.com/s/3gf5Oxe7",
                "https://eyun.baidu.com/s/3gfqpuin"
            )
        )

        "wii_mx" -> GameData(
            listOf(jpVersion, usVersion, cnVersion),
            listOf(
                "https://eyun.baidu.com/s/3i5UCDpz",
                "https://eyun.baidu.com/s/3dFACfWd",
                "https://eyun.baidu.com/s/3eRYayD8"
            )
        )

        "nds_cm" -> GameData(
            listOf(jpVersion, usVersion, cnVersion),
            listOf(
                "https://eyun.baidu.com/s/3hsqS3S4",
                "https://eyun.baidu.com/s/3c27V89i",
                "https://eyun.baidu.com/s/3i5Pwsxn"
            )
        )

        "nds_kssu" -> GameData(
            listOf(jpVersion, usVersion, cnVersion),
            listOf(
                "https://eyun.baidu.com/s/3i4Ricbb",
                "https://eyun.baidu.com/s/3nvCwXlB",
                "https://eyun.baidu.com/s/3c2EblZi"
            )
        )

        "nds_nht" -> GameData(
            listOf(jpVersion, usVersion, cnVersion),
            listOf(
                "https://eyun.baidu.com/s/3bo4Z5TH",
                "https://eyun.baidu.com/s/3czmilC",
                "https://eyun.baidu.com/s/3hr4PxbA"
            )
        )

        "nds_jh" -> GameData(
            listOf(jpVersion, usVersion, "「那个」汉化组 $cnVersion", cnVersion),
            listOf(
                "https://eyun.baidu.com/s/3geO4mbx",
                "https://eyun.baidu.com/s/3eSijdHS",
                "https://eyun.baidu.com/s/3kVVCFFx",
                "https://eyun.baidu.com/s/3o80PA6e"
            )
        )

        "gb_x1" -> GameData(
            listOf(jpVersion, usVersion),
            listOf(
                "https://eyun.baidu.com/s/3pKN6dIz",
                "https://eyun.baidu.com/s/3miPUVES"
            )
        )

        "gb_x2" -> GameData(
            listOf(jpVersion, usVersion),
            listOf(
                "https://eyun.baidu.com/s/3i57Kjjv",
                "https://eyun.baidu.com/s/3jI4urlW"
            )
        )

        "gb_bsx" -> GameData(
            listOf(jpVersion, usVersion),
            listOf(
                "https://eyun.baidu.com/s/3miFgbtI",
                "https://eyun.baidu.com/s/3nvtzunn"
            )
        )

        "gb_dzk" -> GameData(
            listOf(jpVersion, usVersion),
            listOf(
                "https://eyun.baidu.com/s/3i5Dkqah",
                "https://eyun.baidu.com/s/3ge7808r"
            )
        )

        "gb_dzt" -> GameData(
            listOf(jpVersion, usVersion),
            listOf(
                "https://eyun.baidu.com/s/3i48QqMh",
                "https://eyun.baidu.com/s/3eSwv1DK"
            )
        )

        "gbc_gg" -> GameData(
            listOf(jpVersion, usVersion),
            listOf(
                "https://eyun.baidu.com/s/3pKP9eav",
                "https://eyun.baidu.com/s/3qZZMtZY"
            )
        )

        "fc_mzq" -> GameData(
            listOf(jpVersion, usVersion, cnVersion),
            listOf(
                "https://eyun.baidu.com/s/3pKXFx8n",
                "https://eyun.baidu.com/s/3pKZHpaF",
                "https://eyun.baidu.com/s/3i4HC8FN"
            )
        )
        else -> GameData(listOf(), listOf())
    }
}