package com.gdsc.gdsctoast

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.gdsc.gdsctoast.databinding.GdscToastLayoutBinding

class GDSCToast(private val context: Context): Toast(context) {

    companion object {

        private fun showNormalText(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {

            val toast = Toast(context)
            val layout = buildToast(context)

            layout.apply {
                toastIdentifier.setBackgroundResource(R.drawable.shape_normal)
                if (showLogo)
                    ivGdscLogoDownside.visibility = View.VISIBLE
                else
                    ivGdscLogoDownside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.visibility = View.VISIBLE
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }

        private fun showSuccessText(context: Context, text: String, duration: Int, showLogo: Boolean = true): Toast {
            val toast = Toast(context)
            val layout = buildToast(context)

            layout.apply {
                toastIdentifier.setBackgroundResource(R.drawable.shape_success)
                if (showLogo)
                    ivGdscLogoUpside.visibility = View.VISIBLE
                else
                    ivGdscLogoUpside.visibility = View.INVISIBLE

                tvInformation.text = text
                ivCondition.apply {
                    setImageResource(R.drawable.ic_success)
                    visibility = View.VISIBLE
                }
            }

            toast.duration = duration
            toast.view = layout.root
            return toast
        }
        
        private fun buildToast(context: Context): GdscToastLayoutBinding =
            GdscToastLayoutBinding.inflate(LayoutInflater.from(context), null, false)
    }
}