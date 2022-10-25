package com.example.improve.data

import com.example.improve.model.Rpe

object DataSource {
    val rpeList: List<Rpe> = listOf(
        Rpe(
            5.0,
            mapOf(
                1 to 0.837,
                2 to 0.811,
                3 to 0.786,
                4 to 0.762,
                5 to 0.739,
                6 to 0.707,
                7 to 0.68,
                8 to 0.653,
                9 to 0.626,
                10 to 0.599
            )
        ),
        Rpe(
            5.5,
            mapOf(
                1 to 0.85,
                2 to 0.824,
                3 to 0.798,
                4 to 0.774,
                5 to 0.750,
                6 to 0.723,
                7 to 0.693,
                8 to 0.666,
                9 to 0.639,
                10 to 0.612
            )
        ),
        Rpe(
            6.0,
            mapOf(
                1 to 0.863,
                2 to 0.837,
                3 to 0.811,
                4 to 0.786,
                5 to 0.762,
                6 to 0.739,
                7 to 0.707,
                8 to 0.68,
                9 to 0.653,
                10 to 0.626,
            )
        ),
        Rpe(
            6.5,
            mapOf(
                1 to 0.877,
                2 to 0.85,
                3 to 0.824,
                4 to 0.798,
                5 to 0.774,
                6 to 0.750,
                7 to 0.723,
                8 to 0.693,
                9 to 0.666,
                10 to 0.639
            )
        ),
        Rpe(
            7.0,
            mapOf(
                1 to 0.892,
                2 to 0.863,
                3 to 0.837,
                4 to 0.811,
                5 to 0.786,
                6 to 0.762,
                7 to 0.739,
                8 to 0.707,
                9 to 0.68,
                10 to 0.653
            )
        ),
        Rpe(
            7.5,
            mapOf(
                1 to 0.907,
                2 to 0.877,
                3 to 0.85,
                4 to 0.824,
                5 to 0.798,
                6 to 0.774,
                7 to 0.750,
                8 to 0.723,
                9 to 0.693,
                10 to 0.666
            )
        ),
        Rpe(
            8.0,
            mapOf(
                1 to 0.922,
                2 to 0.892,
                3 to 0.863,
                4 to 0.837,
                5 to 0.811,
                6 to 0.786,
                7 to 0.762,
                8 to 0.739,
                9 to 0.707,
                10 to 0.68
            )
        ),
        Rpe(
            8.5,
            mapOf(
                1 to 0.938,
                2 to 0.907,
                3 to 0.877,
                4 to 0.85,
                5 to 0.824,
                6 to 0.798,
                7 to 0.774,
                8 to 0.750,
                9 to 0.723,
                10 to 0.693
            )
        ),
        Rpe(
            9.0,
            mapOf(
                1 to 0.955,
                2 to 0.922,
                3 to 0.892,
                4 to 0.863,
                5 to 0.837,
                6 to 0.811,
                7 to 0.786,
                8 to 0.762,
                9 to 0.739,
                10 to 0.707
            )
        ),
        Rpe(
            9.5,
            mapOf(
                1 to 0.977,
                2 to 0.938,
                3 to 0.907,
                4 to 0.877,
                5 to 0.85,
                6 to 0.824,
                7 to 0.798,
                8 to 0.774,
                9 to 0.750,
                10 to 0.723
            )
        ),
        Rpe(
            10.0,
            mapOf(
                1 to 1.0,
                2 to 0.955,
                3 to 0.922,
                4 to 0.892,
                5 to 0.863,
                6 to 0.837,
                7 to 0.811,
                8 to 0.786,
                9 to 0.762,
                10 to 0.739
            )
        )
    )

    fun getRpeValue(rpe: Double, reps: Int): Double? {
        val findRpe = rpeList.find { it.rpe == rpe }
        return findRpe?.repValue?.get(reps)
    }
}