package com.proyectoapp.supercarrito.adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyectoapp.supercarrito.R;
import com.proyectoapp.supercarrito.modelo.Producto;

import java.util.ArrayList;

import static com.proyectoapp.supercarrito.R.drawable.ic_shopping_cart_black_24dp;

public class RecyclerProductoAdapter extends RecyclerView.Adapter<RecyclerProductoAdapter.ProductoViewHolder> {

    private Context mContext;
    private int layoutResource;
    private ArrayList<Producto> arrayListProductos;

    public RecyclerProductoAdapter(Context mContext, int layoutResource, ArrayList<Producto> arrayListProductos) {
        this.mContext = mContext;
        this.layoutResource = layoutResource;
        this.arrayListProductos = arrayListProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(layoutResource,parent ,false);

        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto= arrayListProductos.get(position);
        holder.mMarcaProducto.setText(producto.getMarca());
        holder.mNombreProducto.setText(producto.getNombreo());
        holder.mPrecio.setText(producto.getPrecio());
        holder.mCantidad.setText(producto.getCantidad());

        holder.mImagenProducto.setImageResource(ic_shopping_cart_black_24dp);

    }

    @Override
    public int getItemCount() {

        if (arrayListProductos.size()>0){
            return arrayListProductos.size();
        }

        return 0;
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mNombreProducto,mMarcaProducto,mPrecio,mCantidad;
        ImageView mImagenProducto;


        @SuppressLint("ResourceType")
        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            mMarcaProducto = itemView.findViewById(R.id.txtMarcaRowDatos);
            mNombreProducto = itemView.findViewById(R.id.txtNombreRowDatos);
            mPrecio = itemView.findViewById(R.id.txtPrecioRowDatos);
            mCantidad = itemView.findViewById(R.id.txtCantidadaRowDatos);
            mImagenProducto = itemView.findViewById(ic_shopping_cart_black_24dp);
        }

        @Override
        public void onClick(View v) {

        }
    }

}

