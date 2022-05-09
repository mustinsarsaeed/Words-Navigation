/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wordsapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.ActivityMainBinding

/**
 * Main Activity and entry point for the app. Displays a RecyclerView of letters.
 */
class MainActivity : AppCompatActivity() {
/*    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true*/

    //Configure Navigation MainActiviy 1 ) Create a navController property. This is marked as lateinit since it will be set in onCreate.
    private lateinit var navController: NavController

    //Implement LetterListFragment 11) after add code in LetterListFragment remaining code in MainActivity is only onCreate method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Configure Navigation 2) Then, after the call to setContentView() in onCreate(), get a reference to the
        // nav_host_fragment (this is the ID of your FragmentContainerView) and assign it to your navController property.
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        //Configure Navigation 3) Then in onCreate(), call setupActionBarWithNavController(), passing in navController.
        // This ensures action bar (app bar) buttons, like the menu option in LetterListFragment are visible
        setupActionBarWithNavController(navController)
    }
        //Configure Navigation 4) Finally, implement onSupportNavigateUp(). Along with setting defaultNavHost to true in the XML,
        // this method allows you to handle the up button. However, your activity needs to provide the implementation.
        override fun onSupportNavigateUp(): Boolean {
            return navController.navigateUp() || super.onSupportNavigateUp()
        }


        //This code execute when Detail and Main Activity Execute
        /*recyclerView = binding.recyclerView
        chooseLayout()
        // Sets the LinearLayoutManager of the recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LetterAdapter()
    }

    private fun chooseLayout(){
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        recyclerView.adapter = LetterAdapter()
    }

    private  fun setIcon(menuItem: MenuItem?){
        if (menuItem == null) {
            return
            menuItem?.icon = if (isLinearLayoutManager) {
                ContextCompat.getDrawable(this,R.drawable.ic_grid_layout)
            } else {
                ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu,menu)

        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }*/

}
