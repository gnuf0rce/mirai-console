/*
 * Copyright 2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package net.mamoe.mirai.console

import net.mamoe.mirai.Bot
import net.mamoe.mirai.utils.LoginSolver
import net.mamoe.mirai.utils.MiraiLogger

/**
 * 只需要实现一个这个传入 MiraiConsole 就可以绑定 UI 层与 Console 层
 * 需要保证线程安全
 */
interface MiraiConsoleFrontEnd {
    /**
     * 名称
     */
    val name: String

    /**
     * 版本
     */
    val version: String

    fun loggerFor(identity: String?): MiraiLogger

    /**
     * 让 UI 层接受一个新的bot
     * */
    fun pushBot(
        bot: Bot
    )

    /**
     * 让 UI 层提供一个输入, 相当于 [readLine]
     */
    suspend fun requestInput(hint: String): String

    /**
     * 由 UI 层创建一个 [LoginSolver]
     */
    fun createLoginSolver(): LoginSolver
}