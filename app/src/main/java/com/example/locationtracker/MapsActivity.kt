package com.example.locationtracker

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.locationtracker.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private val LOCATION_PERMISSION_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun getLocationAccess() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            map.isMyLocationEnabled = true
        }
        else
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),LOCATION_PERMISSION_REQUEST)
        }
    }

   override fun onRequestPermissionsResult(requestCode:Int, permissions:Array<String>, grantResults:IntArray)
    {
       if (requestCode == LOCATION_PERMISSION_REQUEST)
        {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED))
            {
                map.isMyLocationEnabled = true
            }
            else {
                Toast.makeText(this, "User has not granted location permission", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        //Toast.makeText(this, "test dialog3", Toast.LENGTH_LONG).show()
        //Toast.makeText(getApplicationContext(), " Hello World", Toast.LENGTH_SHORT).show();
        getLocationAccess()

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        // Add a marker in Hoboken and move the camera

       /*var zommLevel = 15f
        val hoboken = LatLng(40.745255, -74.034775)
        map.addMarker(
            MarkerOptions().position(hoboken).title("Hoboken, NJ")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        )
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(hoboken, zommLevel))
        */

    }

} //end of MapsActivity