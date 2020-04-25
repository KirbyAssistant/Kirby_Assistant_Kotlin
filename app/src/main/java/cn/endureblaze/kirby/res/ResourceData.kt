package cn.endureblaze.kirby.res

import cn.endureblaze.kirby.R
import cn.endureblaze.kirby.res.dataclass.CheatCodeGame
import cn.endureblaze.kirby.res.dataclass.Console
import cn.endureblaze.kirby.res.dataclass.Emulator
import cn.endureblaze.kirby.utils.ActManager

/**
 * 用于初始化资源界面的列表数据
 */
object ResourceData {

    private val consoleData = arrayOf(
        Console("gba", "https://api.endureblaze.cn/ka_image/consose/gba.png", "gba"),
        Console("sfc", "https://api.endureblaze.cn/ka_image/consose/sfc.png", "sfc"),
        Console("n64", "https://api.endureblaze.cn/ka_image/consose/n64.png", "n64"),
        Console("ngc", "https://api.endureblaze.cn/ka_image/consose/ngc.png", "ngc"),
        Console("wii", "https://api.endureblaze.cn/ka_image/consose/wii.png", "wii"),
        Console("nds", "https://api.endureblaze.cn/ka_image/consose/nds.png", "nds"),
        Console("gb", "https://api.endureblaze.cn/ka_image/consose/gb.png", "gb"),
        Console("gbc", "https://api.endureblaze.cn/ka_image/consose/gbc.png", "gbc"),
        Console("fc", "https://api.endureblaze.cn/ka_image/consose/fc.png", "fc")
    )

    private val emulatorData = arrayOf(
        Emulator(
            "GBA $emulatorText My Boy!",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_gba.png",
            "emulator_gba"
        ),
        Emulator(
            "SFC $emulatorText Snes9x EX+",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_sfc.png",
            "emulator_sfc"
        ),
        Emulator(
            "N64 $emulatorText Tendo64",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_n64.png",
            "emulator_n64"
        ),
        Emulator(
            "NDS $emulatorText DraStic",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_nds.png",
            "emulator_nds"
        ),
        Emulator(
            "NGC&WII $emulatorText Dolphin",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_wii.png",
            "emulator_wii"
        ),
        Emulator(
            "GB&GBC $emulatorText My OldBoy!",
            "https://api.endureblaze.cn/ka_image/moniqi/moniqi_gb_gbc.png",
            "emulator_gb"
        ),
        Emulator("FC $emulatorText NES.emu", "https://api.endureblaze.cn/ka_image/moniqi/moniqi_fc.png", "emulator_fc")
    )

    private val cheatCodeGameData = arrayOf(
        CheatCodeGame("星之卡比 梦之泉物语", "https://api.endureblaze.cn/ka_image/game/mengzhiquan.jpg", "fc_mzq"),
        CheatCodeGame("星之卡比 梦之泉DX", "https://api.endureblaze.cn/ka_image/game/mengzhiquandx.jpg", "gba_mzqdx"),
        CheatCodeGame("星之卡比 镜之大迷宫", "https://api.endureblaze.cn/ka_image/game/jingmi.jpg", "gba_jm")
    )

    private val emulatorText: String?
        get() = ActManager.currentActivity?.resources?.getString(R.string.tab_emulator)

    fun initConsoleData(list: MutableList<Console>) {
        for (ele in consoleData) {
            list.add(ele)
        }
    }

    fun initEmulatorData(list: MutableList<Emulator>) {
        for (ele in emulatorData) {
            list.add(ele)
        }
    }
}
