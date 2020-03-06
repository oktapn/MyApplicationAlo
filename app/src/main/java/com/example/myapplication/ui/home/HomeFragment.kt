package com.example.myapplication.ui.home


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.ui.listabsen.ListAbsenActivity
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * alo simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAbsen.setOnClickListener(this)
        btnListAbsen.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAbsen -> {
                checkCameraPermission()
            }
            R.id.btnListAbsen -> {
                val intent = Intent(context, ListAbsenActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
//            val image = data?.extras!!["data"] as Bitmap?
//            // do whatever you want with the image now
        }
    }

    fun checkCameraPermission(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity!!, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity!!,
                    Manifest.permission.READ_CONTACTS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(activity!!,
                    arrayOf(Manifest.permission.CAMERA),
                    0)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, 0)
        }
    }
}
