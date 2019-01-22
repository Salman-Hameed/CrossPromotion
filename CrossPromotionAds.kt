package com.example.thetamobile.crosspromotionads

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.DataSnapshot


/*
 * Created by SalmanHameed on 1/18/2019.
 */
class CrossPromotionAds(context: Context, loadImageListener: LoadImageListener) {

    interface LoadImageListener {
        fun imageLoaded(boolean: Boolean)
    }

    var mLoadImageListener = loadImageListener
    var mContext: Context = context
    var databaseReference: DatabaseReference? = null
    var applicationId: String = mContext.packageName
    var nodeModel: NodeModel = NodeModel()

    var nodeModelList = ArrayList<NodeModel>()

    var applicationLink = ""
    var applicationGifLink = ""

    val TAG: String = CrossPromotionAds::class.java.simpleName

    init {


    }

    fun getApplicationAd() {

        applicationId = applicationId.replace(".", "_")
        databaseReference = FirebaseDatabase.getInstance().reference.child(applicationId)

        Log.i(TAG, databaseReference?.path.toString())

        databaseReference?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {

                for (snapshot in p0.children) {
//                    val carDatabaseModel = snapshot.getValue(CarDatabaseModel::class.java!!)
                    nodeModelList.add(snapshot.getValue(NodeModel::class.java)!!)
                }

                mLoadImageListener.imageLoaded(true)
                Toast.makeText(mContext, "Maximum models available: " + nodeModelList.size, Toast.LENGTH_LONG).show()

            }
        })
    }

    fun getFbNodeModel(): ArrayList<NodeModel> {
        return nodeModelList
    }
}