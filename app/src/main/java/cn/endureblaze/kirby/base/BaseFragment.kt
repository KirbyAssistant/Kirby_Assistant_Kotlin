package cn.endureblaze.kirby.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlin.properties.Delegates



abstract class BaseFragment : Fragment() {

    private var isFragmentVisible by Delegates.notNull<Boolean>()
    private var isReuseView by Delegates.notNull<Boolean>()
    private var isFirstVisible by Delegates.notNull<Boolean>()
    private var rootView: View? = null

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        //setUserVisibleHint()有可能在fragment的生命周期外被调用
        if (rootView == null) {
            return
        }
        if (isFirstVisible and isVisibleToUser) {
            onFragmentFirstVisible()
            isFirstVisible = false
        }
        if (isVisibleToUser) {
            onFragmentVisibleChange(true)
            isFragmentVisible = true
            return
        }
        if (isFragmentVisible) {
            isFragmentVisible = false
            onFragmentVisibleChange(false)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVariable()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if(rootView == null){
            rootView = view
            if(userVisibleHint){
                if(isFirstVisible){
                    onFragmentFirstVisible()
                    isFirstVisible = false
                }
                onFragmentVisibleChange(true)
                isFragmentVisible = true
            }
        }
        (if (isReuseView) rootView else view)?.let { super.onViewCreated(it, savedInstanceState) }
    }

    override fun onDestroy() {
        super.onDestroy()
        initVariable()
    }

    private fun initVariable(){
        isFirstVisible = true
        isFragmentVisible = false
        rootView = null
        isReuseView = true
    }

    abstract fun onFragmentVisibleChange(isVisible:Boolean)

    abstract fun onFragmentFirstVisible()
}