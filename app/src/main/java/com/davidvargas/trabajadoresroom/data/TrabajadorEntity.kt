package com.davidvargas.trabajadoresroom.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "trabajadores")
class TrabajadorEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "id")
    var id: Int = 0,
    @ColumnInfo(name= "nombre")
    var name: String? = null,
    @ColumnInfo(name= "puesto")
    var puesto: String? = null,
    @ColumnInfo(name= "antiguedad")
    var antiguedad: String? = null
) {
}