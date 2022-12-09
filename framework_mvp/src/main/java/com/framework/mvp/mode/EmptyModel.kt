package com.framework.mvp.mode

import com.framework.mvp.EmptyContract


/**
 * @author: xiaxueyi
 * @date: 2021-04-22
 * @time: 10:42
 * @说明:
 */
class EmptyModel : BaseModel(), EmptyContract.Model {


    override fun getEmptyData() {

    }
}

