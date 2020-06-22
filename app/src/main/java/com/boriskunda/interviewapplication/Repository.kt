package com.boriskunda.interviewapplication

class Repository private constructor() {

    companion object {

        val instance: Repository by lazy { Repository() }
        /**
        The by lazy{}indicates it will be computed on the first access only.
        The evaluation of lazy properties is synchronized, the value is computed only in one thread,
        and all threads will see the same value.
         */

    }

}