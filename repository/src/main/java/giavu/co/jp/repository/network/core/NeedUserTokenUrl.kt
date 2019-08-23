package giavu.co.jp.repository.network.core

/**
 * @Author: Hoang Vu
 * @Date:   2019/01/23
 */
enum class NeedUserTokenUrl(val url: String) {
    DELETE_USER("https://favqs.com/api/session"),
    GET_USER("https://favqs.com/api/users")
}