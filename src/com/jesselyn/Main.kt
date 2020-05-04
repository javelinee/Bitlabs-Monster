package com.jesselyn

import com.jesselyn.entity.MagicWeapon
import com.jesselyn.entity.Weapon
import java.util.*

var scanner = Scanner(System.`in`)

fun main(){
    initWeapon()
    do{
        initMenu()
        val menu = scanner.nextInt()
        scanner.nextLine()
        when(menu){
            1 -> createItem()
            2 -> viewItem()
            3 -> updateItem()
            4 -> deleteItem()
        }
    }while(menu != 5)
}

fun initMenu(){
    println("Welcome to Dungeon Store Admin Panel")
    println("====================================")
    println("1. Create Item")
    println("2. View Item")
    println("3. Update Item")
    println("4. Delete Item")
    println("5. Exit")
    print("Choose Menu : ")
}

var listWeapon = mutableListOf<Weapon>()
var listMagicWeapon = mutableListOf<MagicWeapon>()

fun initWeapon(){
    val weapon = Weapon()
    weapon.name = "Long Sword"
    weapon.damage = 70
    listWeapon.add(weapon)

    val magicWeapon = MagicWeapon()
    magicWeapon.name = "Fire Sword"
    magicWeapon.damage = 85
    magicWeapon.magicDamage = 75
    listMagicWeapon.add(magicWeapon)
}

fun createItem(){
    do{
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose : ")

        val choose = scanner.nextInt()
        scanner.nextLine()

        when (choose){
            1 -> {
                val weapon = Weapon()
                println()
                print("Weapon's Name : ")
                weapon.name = scanner.nextLine()

                print("Weapon's Damage : ")
                weapon.damage = scanner.nextInt()
                scanner.nextLine()

                listWeapon.add(weapon)
                println("Successfully created weapon!")
                println()
            }

            2 -> {
                var magicWeapon = MagicWeapon()
                println()
                print("Magic Weapon's Name : ")
                magicWeapon.name = scanner.nextLine()

                print("Weapon's Damage : ")
                magicWeapon.damage = scanner.nextInt()
                scanner.nextLine()

                print("Weapon's Magic Damage : ")
                magicWeapon.magicDamage = scanner.nextInt()
                scanner.nextLine()

                listMagicWeapon.add(magicWeapon)
                println("Successfully created magic weapon!")
                println()
            }

            else -> {
                println("Choose 1 or 2")
            }
        }

    }while(choose > 2)
}

fun viewItem(){
    do{
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose : ")

        val choose = scanner.nextInt()
        scanner.nextLine()

        when(choose){
            1 -> {
                println()
                println("Weapon")
                println("=======================")
                listWeapon.forEachIndexed { index, weapon ->
                    println("${index+1}. ${weapon.name} ${weapon.damage}")
                }
                println()
            }

            2 -> {
                println()
                println("Magic Weapon")
                println("========================")
                listMagicWeapon.forEachIndexed { index, magicWeapon ->
                    println("${index+1}. ${magicWeapon.name} ${magicWeapon.damage} ${magicWeapon.magicDamage}")
                }
                println()
            }
        }
    }while(choose > 2)
}

fun updateItem(){
    do{
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose : ")

        val choose = scanner.nextInt()
        scanner.nextLine()

        when(choose){
            1 -> {
                println()
                println("Weapon")
                println("=======================")
                listWeapon.forEachIndexed { index, weapon ->
                    println("${index+1}. ${weapon.name} ${weapon.damage}")
                }

                do{
                    println()
                    print("Choose Weapon to be Updated: ")
                    val chooseWeapon = scanner.nextInt()
                    scanner.nextLine()

                    val weapon = listWeapon[chooseWeapon-1]
                    print("Weapon's Name : ")
                    weapon.name = scanner.nextLine()

                    print("Weapon's Damage : ")
                    weapon.damage = scanner.nextInt()
                    scanner.nextLine()

                    println("Weapon's updated!")
                    println()
                }while(chooseWeapon > listWeapon.size)
            }

            2 -> {
                println()
                println("Magic Weapon")
                println("========================")
                listMagicWeapon.forEachIndexed { index, magicWeapon ->
                    println("${index+1}. ${magicWeapon.name} ${magicWeapon.damage} ${magicWeapon.magicDamage}")
                }

                do{
                    println()
                    print("Choose Magic Weapon to be Updated: ")
                    val chooseMagicWeapon = scanner.nextInt()
                    scanner.nextLine()

                    val magicWeapon = listMagicWeapon[chooseMagicWeapon-1]
                    print("Weapon's Name : ")
                    magicWeapon.name = scanner.nextLine()

                    print("Weapon's Damage : ")
                    magicWeapon.damage = scanner.nextInt()
                    scanner.nextLine()

                    print("Magic Weapon's Damage : ")
                    magicWeapon.magicDamage = scanner.nextInt()
                    scanner.nextLine()

                    println("Magic Weapon's updated!")
                    println()
                }while(chooseMagicWeapon > listMagicWeapon.size)
            }
        }
    }while(choose > 2)
}

fun deleteItem(){
    do{
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose : ")

        val choose = scanner.nextInt()
        scanner.nextLine()

        when(choose){
            1 -> {
                println()
                println("Weapon")
                println("=======================")
                listWeapon.forEachIndexed { index, weapon ->
                    println("${index+1}. ${weapon.name} ${weapon.damage}")
                }

                print("Choose Weapon to delete : ")
                val chooseItem = scanner.nextInt()
                scanner.nextLine()
                listWeapon.removeAt(chooseItem - 1)
                println("Succesfully deleted a Weapon!")
                println()
            }

            2 -> {
                println()
                println("Magic Weapon")
                println("========================")
                listMagicWeapon.forEachIndexed { index, magicWeapon ->
                    println("${index+1}. ${magicWeapon.name} ${magicWeapon.damage} ${magicWeapon.magicDamage}")
                }

                print("Choose Magic Weapon to delete : ")
                val chooseItem = scanner.nextInt()
                scanner.nextLine()
                listMagicWeapon.removeAt(chooseItem - 1)
                println("Succesfully deleted a Magic Weapon!")
                println()
            }
        }
    }while(choose > 2)
}