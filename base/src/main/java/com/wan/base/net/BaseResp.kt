package com.wan.base.net

/**
 * desc:请求成功返回数据实体抽象类
 */
abstract class BaseResp<T> {

    abstract fun requestSuccess(): Boolean
    abstract fun getRespCode(): Int
    abstract fun getRespData(): T
    abstract fun getRespMsg(): String
}