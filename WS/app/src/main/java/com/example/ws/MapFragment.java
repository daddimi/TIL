package com.example.ws;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {

    Booking b;
    TextView txmap, txmap2;
    LocationManager locationManager;
    SupportMapFragment supportMapFragment;
    MapView gmap;
    GoogleMap googleMap;
    //alertdialog에 getActivity로 ,,,....

    public MapFragment(Booking b) {
        this.b = b;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = null;
        viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_map, container, false);

        gmap = (MapView) viewGroup.findViewById(R.id.map);
        gmap.onCreate(savedInstanceState);
        gmap.onResume();

        MapsInitializer.initialize(getActivity().getApplicationContext());

        gmap.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng latlng = new LatLng(37.512450, 127.058800);

                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                googleMap.setMyLocationEnabled(true);
                googleMap.addMarker(new MarkerOptions().position(latlng).title("코엑스점").snippet("서울특별시 강남구 삼성1동 봉은사로 524"));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,10));

                latlng = new LatLng(37.566911, 127.007224);
                googleMap.addMarker(new MarkerOptions().position(latlng).title("동대문점").snippet("서울특별시 중구 광희동 장충단로 247"));
                latlng = new LatLng(37.541761, 127.045012);
                googleMap.addMarker(new MarkerOptions().position(latlng).title("성수점").snippet("서울특별시 성동구 성수1가1동 656-335"));
                latlng = new LatLng(37.504615, 127.004201);
                googleMap.addMarker(new MarkerOptions().position(latlng).title("센트럴점").snippet("서울특별시 서초구 반포동 신반포로 176"));
                latlng = new LatLng(37.484679, 126.981605);
                googleMap.addMarker(new MarkerOptions().position(latlng).title("이수점").snippet("서울특별시 동작구 사당동 147-53"));
                latlng = new LatLng(37.559641, 126.942239);
                googleMap.addMarker(new MarkerOptions().position(latlng).title("신촌점").snippet("서울특별시 서대문구 신촌동 신촌역로 30"));
                latlng = new LatLng(37.654580, 127.038828);
                googleMap.addMarker(new MarkerOptions().position(latlng).title("창동점").snippet("서울특별시 도봉구 창동 도봉로 558"));
                latlng = new LatLng(37.617816, 126.922877);
                googleMap.addMarker(new MarkerOptions().position(latlng).title("은평점").snippet("서울특별시 은평구 불광동 304-2"));
                latlng = new LatLng(37.593162, 127.074750);
                googleMap.addMarker(new MarkerOptions().position(latlng).title("상봉점").snippet("서울특별시 중랑구 상봉동 망우로30길 3"));
                latlng = new LatLng(37.528409, 127.125333);
                googleMap.addMarker(new MarkerOptions().position(latlng).title("강동점").snippet("서울특별시 강동구 성내동 549-2"));


            }
        });



        return viewGroup;
    }
}