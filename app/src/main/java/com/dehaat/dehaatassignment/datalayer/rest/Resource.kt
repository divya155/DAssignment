package com.dehaat.dehaatassignment.datalayer.rest

import com.dehaat.dehaatassignment.datalayer.model.Status
import com.dehaat.dehaatassignment.datalayer.model.Status.ERROR
import com.dehaat.dehaatassignment.datalayer.model.Status.LOADING
import com.dehaat.dehaatassignment.datalayer.model.Status.SUCCESS

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> =
                Resource(
                        status = SUCCESS,
                        data = data,
                        message = "Success"
                )

        fun <T> error(data: T?, message: String?): Resource<T> =
                Resource(
                        status = ERROR,
                        data = data,
                        message = message
                )

        fun <T> loading(data: T?): Resource<T> =
                Resource(
                        status = LOADING,
                        data = data,
                        message = null
                )
    }
}