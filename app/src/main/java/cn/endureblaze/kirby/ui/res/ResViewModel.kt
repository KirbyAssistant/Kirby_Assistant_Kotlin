package cn.endureblaze.kirby.ui.res

import androidx.lifecycle.ViewModel
import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.logic.model.ResItem
import cn.endureblaze.kirby.utils.ActManager

class ResViewModel : ViewModel() {

    var consoleList = listOf(
        ResItem(
            "GBA",
            "https://api.endureblaze.cn/ka_image/consose/gba.png",
            "gba",
            "console"
        ),
        ResItem(
            "SFC",
            "https://api.endureblaze.cn/ka_image/consose/sfc.png",
            "sfc",
            "console"
        ),
        ResItem(
            "N64",
            "https://api.endureblaze.cn/ka_image/consose/n64.png",
            "n64",
            "console"
        ),
        ResItem(
            "NGC",
            "https://api.endureblaze.cn/ka_image/consose/ngc.png",
            "ngc",
            "console"
        ),
        ResItem(
            "Wii",
            "https://api.endureblaze.cn/ka_image/consose/wii.png",
            "wii",
            "console"
        ),
        ResItem(
            "NDS",
            "https://api.endureblaze.cn/ka_image/consose/nds.png",
            "nds",
            "console"
        ),
        ResItem(
            "GB",
            "https://api.endureblaze.cn/ka_image/consose/gb.png",
            "gb",
            "console"
        ),
        ResItem(
            "GBC",
            "https://api.endureblaze.cn/ka_image/consose/gbc.png",
            "gbc",
            "console"
        ),
        ResItem(
            "FC",
            "https://api.endureblaze.cn/ka_image/consose/fc.png",
            "fc",
            "console"
        )
    )

    var emulatorList = listOf(
        ResItem(
            "GBA $emulatorText My Boy!",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_gba.png",
            "emulator_gba",
            "emulator"
        ),
        ResItem(
            "SFC $emulatorText Snes9x EX+",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_sfc.png",
            "emulator_sfc",
            "emulator"
        ),
        ResItem(
            "N64 $emulatorText Tendo64",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_n64.png",
            "emulator_n64",
            "emulator"
        ),
        ResItem(
            "NDS $emulatorText DraStic",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_nds.png",
            "emulator_nds"
        ),
        ResItem(
            "NGC&WII $emulatorText Dolphin",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_wii.png",
            "emulator_wii",
            "emulator"
        ),
        ResItem(
            "GB&GBC $emulatorText My OldBoy!",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_gb_gbc.png",
            "emulator_gb",
            "emulator"
        ),
        ResItem(
            "FC $emulatorText NES.emu",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_fc.png",
            "emulator_fc",
            "emulator"
        )
    )

    val cheatcodeGameList = listOf(
        ResItem(
            "星之卡比 梦之泉物语",
            "https://api.endureblaze.cn/ka_image/game/mengzhiquan.jpg",
            "fc_mzq",
            "cheatcode"
        ),
        ResItem(
            "星之卡比 梦之泉DX",
            "https://api.endureblaze.cn/ka_image/game/mengzhiquandx.jpg",
            "gba_mzqdx",
            "cheatcode"
        ),
        ResItem(
            "星之卡比 镜之大迷宫",
            "https://api.endureblaze.cn/ka_image/game/jingmi.jpg",
            "gba_jm",
            "cheatcode"
        )
    )

    private val emulatorText: String?
        get() = ActManager.currentActivity.resources?.getString(R.string.tab_emulator)

}