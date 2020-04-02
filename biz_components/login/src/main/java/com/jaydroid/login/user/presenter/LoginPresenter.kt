package com.jaydroid.login.user.presenter

import com.jaydroid.login.user.contract.LoginContract
import com.jaydroid.base_component.base.mvp.BaseObserver
import com.jaydroid.base_component.base.mvp.BasePresenter
import com.jaydroid.base_component.network.bean.wan.LoggedInEvent
import com.jaydroid.base_component.network.bean.wan.User
import org.greenrobot.eventbus.EventBus

class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun login(username: String, password: String) {
        addSubscribe(
            getDefaultNet().login(username, password),
            object : BaseObserver<User>(getView()) {
                override fun onSuccess(user: User?) {
                    getView()?.onLoginResult(username, user)
                    EventBus.getDefault().post(
                        LoggedInEvent(
                            user
                        )
                    )
                }
            })
    }
}