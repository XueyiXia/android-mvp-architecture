package com.framework.mvp.scheduler


/**
 * @author: xiaxueyi
 * @date: 2022-12-05
 * @time: 13:11
 * @说明:
 */
object SchedulerUtils {

    /**
     *
     * @return IoMainScheduler<T>
     */
    fun <T> ioToMainScheduler(): IoMainScheduler<T> {
        return IoMainScheduler()
    }

    /**
     *
     * @return NewThreadMainScheduler<T>
     */
    fun <T> newThreadScheduler() :NewThreadMainScheduler<T>{
        return NewThreadMainScheduler()
    }

    /**
     *
     * @return SingleMainScheduler<T>
     */
    fun <T> singleMainScheduler() :SingleMainScheduler<T>{
        return SingleMainScheduler()
    }

    /**
     *
     * @return ComputationMainScheduler<T>
     */
    fun <T> computationScheduler() :ComputationMainScheduler<T>{
        return ComputationMainScheduler()
    }


    fun <T> trampolineMainScheduler() :TrampolineMainScheduler<T>{
        return TrampolineMainScheduler()
    }

}
