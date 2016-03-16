package com.nagareddy.tabbedactivity.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nagareddy.tabbedactivity.R;
import com.nagareddy.tabbedactivity.logic.ProfileSelection;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        ArrayList<ListviewContactItem> listContact = GetlistContact();

        ListView lv = (ListView) rootView.findViewById(R.id.lv_contact);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
               // Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), ProfileSelection.class); // alwys use getActivity() as first parameter in fragment. Generally. "this" is used while calling an activity from an other activity. For fragments use getActivity
              startActivity(intent);
            }
        });



        lv.setAdapter(new CustomAdapter(getActivity(), listContact));

        return rootView;




//code to get the listView instance using findViewByID etc




    }

    private ArrayList<ListviewContactItem> GetlistContact(){
        ArrayList<ListviewContactItem> contactlist = new ArrayList<ListviewContactItem>();

        ListviewContactItem contact = new ListviewContactItem();

        contact.setName("subash");
      // contact.setPhone(1);
        contact.setImage(R.drawable.mute);
       // contact.setImage2(R.drawable.delete);
        contactlist.add(contact);


        contact = new ListviewContactItem();
        contact.setName("Keerthichandra");
    //  contact.setPhone(2);
        contact.setImage(R.drawable.vibrate);
        contactlist.add(contact);
       // contact.setImage2(R.drawable.delete);

        contact = new ListviewContactItem();
        contact.setName("sarat");
      //  contact.setPhone(3);
        contact.setImage(R.drawable.ringer);
        contactlist.add(contact);
       // contact.setImage2(R.drawable.delete);

        return contactlist;
    }






    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }






        }


