package com.example.drawerlayoutandnavigationviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.drawerlayoutandnavigationviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val activityMainBinding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)


        //If you want to create "burger" icon to show navigation menu you should use this:
        toggle = ActionBarDrawerToggle(this, activityMainBinding.drawerLayout, R.string.open, R.string.close)
        activityMainBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //Turness "burger" into arrow when opened
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //Actual actions when clicked on item menu
        activityMainBinding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.first -> Toast.makeText(this, "First", Toast.LENGTH_LONG).show()
                R.id.second -> Toast.makeText(this, "Second", Toast.LENGTH_LONG).show()
                R.id.third -> Toast.makeText(this, "Third", Toast.LENGTH_LONG).show()
                R.id.fourth -> Toast.makeText(this, "Fourth", Toast.LENGTH_LONG).show()
                R.id.fifth -> Toast.makeText(this, "Fifth", Toast.LENGTH_LONG).show()
            }
            true
        }
    }

    //For "burger"
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}