package dpm.android.with.kotlin.lifecycle.old

import android.content.Intent
import android.os.Bundle
import dpm.android.with.kotlin.R

import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate...")
    }

    private fun navigateToSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        return true
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart...")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume...")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause...")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy...")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart...")
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
