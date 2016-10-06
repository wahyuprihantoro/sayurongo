package id.prihantoro.sayurongo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import id.prihantoro.sayurongo.EditProfileActivity_;
import id.prihantoro.sayurongo.R;
import id.prihantoro.sayurongo.adapter.NavigationDrawerAdapter;
import id.prihantoro.sayurongo.model.NavDrawerItem;
import id.prihantoro.sayurongo.prefs.UserData;

/**
 * Created by Wahyu Prihantoro on 12-Sep-16.
 */

public class FragmentDrawer extends Fragment {

    private static String TAG = FragmentDrawer.class.getSimpleName();
    private static String[] titles = null;
    UserData userData = new UserData();
    private RecyclerView recyclerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationDrawerAdapter adapter;
    private View containerView;
    private FragmentDrawerListener drawerListener;
    private LinearLayout photoLayout;
    private ImageView editProfileButton;

    public FragmentDrawer() {

    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    public List<NavDrawerItem> getData() {
        List<NavDrawerItem> data = new ArrayList<>();

        if (userData.unKnownRole(getContext())) {
            data.add(new NavDrawerItem(true));
            data.add(new NavDrawerItem(R.mipmap.ic_signup_black, "Daftar"));
            data.add(new NavDrawerItem(R.mipmap.ic_signin_black, "Masuk"));
            data.add(new NavDrawerItem(true));
            data.add(new NavDrawerItem(R.mipmap.ic_help_black, "Bantuan"));
            data.add(new NavDrawerItem(R.mipmap.ic_star_black, "Rate App"));
            data.add(new NavDrawerItem(R.mipmap.ic_setup_black, "Pengaturan"));
        } else if (userData.isBuyer(getContext())) {
            data.add(new NavDrawerItem(true));
            data.add(new NavDrawerItem(R.drawable.ic_action_search, "Telusuri"));
            data.add(new NavDrawerItem(R.mipmap.ic_clock_black, "Riwayat"));
            data.add(new NavDrawerItem(true));
            data.add(new NavDrawerItem(R.mipmap.ic_help_black, "Bantuan"));
            data.add(new NavDrawerItem(R.mipmap.ic_star_black, "Rate App"));
            data.add(new NavDrawerItem(R.mipmap.ic_setup_black, "Pengaturan"));
            data.add(new NavDrawerItem(R.mipmap.ic_signout_black, "Keluar"));
        } else {
            data.add(new NavDrawerItem(true));
            data.add(new NavDrawerItem(R.drawable.ic_action_search, "Telusuri"));
            data.add(new NavDrawerItem(R.mipmap.ic_bag_black, "Pesanan"));
            data.add(new NavDrawerItem(R.mipmap.ic_cart_black, "Dagangan"));
            data.add(new NavDrawerItem(R.mipmap.ic_clock_black, "Riwayat"));
            data.add(new NavDrawerItem(true));
            data.add(new NavDrawerItem(R.mipmap.ic_help_black, "Bantuan"));
            data.add(new NavDrawerItem(R.mipmap.ic_star_black, "Rate App"));
            data.add(new NavDrawerItem(R.mipmap.ic_setup_black, "Pengaturan"));
            data.add(new NavDrawerItem(R.mipmap.ic_signout_black, "Keluar"));
        }
        // preparing navigation drawer items
//        for (int i = 0; i < titles.length; i++) {
//            NavDrawerItem navItem = new NavDrawerItem();
//            navItem.setTitle(titles[i]);
//            data.add(navItem);
//        }
        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // drawer labels
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating view layout
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        photoLayout = (LinearLayout) layout.findViewById(R.id.photoLayout);
        if (UserData.getInstance().unKnownRole(getContext())) {
            photoLayout.setVisibility(View.GONE);
        } else {
            photoLayout.setVisibility(View.VISIBLE);
        }
        editProfileButton = (ImageView) layout.findViewById(R.id.editProfileButton);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditProfileActivity_.intent(getContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
            }
        });
        adapter = new NavigationDrawerAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                mDrawerLayout.closeDrawer(containerView);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return layout;
    }


    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    public interface FragmentDrawerListener {
        public void onDrawerItemSelected(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }


    }
}