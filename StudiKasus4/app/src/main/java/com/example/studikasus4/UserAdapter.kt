    package com.example.studikasus4

    import android.content.Context
    import android.content.Intent
    import android.net.Uri
    import android.util.Log
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView

    class UserAdapter(private val context: Context, private val userList: List<UserModel>) :
        RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
            return UserViewHolder(view)
        }

        override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
            val user = userList[position]
            holder.tvName.text = "Nama: ${user.name}"
            holder.tvEmail.text = "Email: ${user.email}"
            holder.tvPhone.text = "Telp: ${user.phone}"
            holder.tvAddress.text = "Alamat: ${user.address}"
            holder.tvGender.text = "Gender: ${user.gender}"
            holder.tvHobbies.text = "Hobi: ${user.hobbies}"
            holder.tvJob.text = "Pekerjaan: ${user.job}"
            holder.tvSatisfactionLevel.text = "Kepuasan: ${user.satisfactionLevel}"
            holder.tvNotificationStatus.text = "Notifikasi: ${user.notificationStatus}"
            holder.tvSelectedDate.text = "Tanggal: ${user.selectedDate}"

            user.imageUri?.let {
                holder.ivProfile.setImageURI(Uri.parse(it))
            } ?: holder.ivProfile.setImageResource(R.drawable.img_avatar_pria)

            holder.itemView.setOnClickListener {
                val position = holder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val user = userList[position]

                    Log.d("UserAdapter", "Item clicked: ${user.name}")
                    val intent = Intent(context, DetailUserActivity::class.java)
                    intent.putExtra("USER", user)
                    context.startActivity(intent)
                }
            }
        }

        override fun getItemCount(): Int = userList.size

        class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvName: TextView = itemView.findViewById(R.id.tvName)
            val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
            val tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
            val tvAddress: TextView = itemView.findViewById(R.id.tvAddress)
            val tvGender: TextView = itemView.findViewById(R.id.tvGender)
            val tvHobbies: TextView = itemView.findViewById(R.id.tvHobbies)
            val tvJob: TextView = itemView.findViewById(R.id.tvJob)
            val tvSatisfactionLevel: TextView = itemView.findViewById(R.id.tvSatisfactionLevel)
            val tvNotificationStatus: TextView = itemView.findViewById(R.id.tvNotificationStatus)
            val tvSelectedDate: TextView = itemView.findViewById(R.id.tvSelectedDate)
            val ivProfile: ImageView = itemView.findViewById(R.id.ivProfile)
        }
    }