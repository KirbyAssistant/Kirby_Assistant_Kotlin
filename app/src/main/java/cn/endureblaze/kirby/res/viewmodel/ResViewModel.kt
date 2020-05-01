package cn.endureblaze.kirby.res.viewmodel

import androidx.lifecycle.ViewModel
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.res.dataclass.ResItem
import cn.endureblaze.kirby.utils.ActManager

class ResViewModel : ViewModel() {

    var consoleList = listOf(
        ResItem("GBA", "https://api.endureblaze.cn/ka_image/consose/gba.png", "gba"),
        ResItem("SFC", "https://api.endureblaze.cn/ka_image/consose/sfc.png", "sfc"),
        ResItem("N64", "https://api.endureblaze.cn/ka_image/consose/n64.png", "n64"),
        ResItem("NGC", "https://api.endureblaze.cn/ka_image/consose/ngc.png", "ngc"),
        ResItem("Wii", "https://api.endureblaze.cn/ka_image/consose/wii.png", "wii"),
        ResItem("NDS", "https://api.endureblaze.cn/ka_image/consose/nds.png", "nds"),
        ResItem("GB", "https://api.endureblaze.cn/ka_image/consose/gb.png", "gb"),
        ResItem("GBC", "https://api.endureblaze.cn/ka_image/consose/gbc.png", "gbc"),
        ResItem("FC", "https://api.endureblaze.cn/ka_image/consose/fc.png", "fc")
    )

    var emulatorList = listOf(
        ResItem(
            "GBA $emulatorText My Boy!",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_gba.png",
            "emulator_gba"
        ),
        ResItem(
            "SFC $emulatorText Snes9x EX+",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_sfc.png",
            "emulator_sfc"
        ),
        ResItem(
            "N64 $emulatorText Tendo64",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_n64.png",
            "emulator_n64"
        ),
        ResItem(
            "NDS $emulatorText DraStic",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_nds.png",
            "emulator_nds"
        ),
        ResItem(
            "NGC&WII $emulatorText Dolphin",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_wii.png",
            "emulator_wii"
        ),
        ResItem(
            "GB&GBC $emulatorText My OldBoy!",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_gb_gbc.png",
            "emulator_gb"
        ),
        ResItem("FC $emulatorText NES.emu", "https://api.endureblaze.cn/ka_image/moniqi/moniqi_fc.png", "emulator_fc")
    )

    val cheatcodeGameList = listOf(
        ResItem("星之卡比 梦之泉物语", "https://api.endureblaze.cn/ka_image/game/mengzhiquan.jpg", "fc_mzq"),
        ResItem("星之卡比 梦之泉DX", "https://api.endureblaze.cn/ka_image/game/mengzhiquandx.jpg", "gba_mzqdx"),
        ResItem("星之卡比 镜之大迷宫", "https://api.endureblaze.cn/ka_image/game/jingmi.jpg", "gba_jm")
    )

    private val emulatorText: String?
        get() = ActManager.currentActivity.resources?.getString(R.string.tab_emulator)

}