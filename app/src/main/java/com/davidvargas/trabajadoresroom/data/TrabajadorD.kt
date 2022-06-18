package com.davidvargas.trabajadoresroom.data

import androidx.room.*

@Dao
interface TrabajadorD {

    @Insert
    fun insertTrabajador (trabajador: TrabajadorEntity)

    @Query("SELECT * FROM trabajadores WHERE nombre =:name")
    fun getWorkerByName(name:String): TrabajadorEntity

    @Query("SELECT * FROM trabajadores")
    fun getAllWorkers (): List<TrabajadorEntity>

    @Query("DELETE FROM trabajadores")
    fun deleteAllWorkers()

    @Delete
    fun deleteWorker(trabajador: TrabajadorEntity)

    @Update
    fun updateWorker(trabajador: TrabajadorEntity)

}