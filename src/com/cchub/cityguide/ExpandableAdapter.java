package com.cchub.cityguide;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableAdapter extends BaseExpandableListAdapter{

	private Context _context;
	private ArrayList<Parent> _listDataHeader;//header title
	public ExpandableAdapter(Context _context, ArrayList<Parent> _listDataHeader) {
		this._context = _context;
		this._listDataHeader = _listDataHeader;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		ArrayList<Child> _listDataChild = _listDataHeader.get(groupPosition).getChildren();
		return _listDataChild.get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		// TODO Auto-generated method stub
		final Child child = (Child) getChild(groupPosition, childPosition);
		 
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.childitem, null);
        }
 
        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.childItemText);
 
        txtListChild.setText(child.getChildText());
        return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		ArrayList<Child> _listDataChild = _listDataHeader.get(groupPosition).getChildren();
		return _listDataChild.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return _listDataHeader.get(groupPosition);
	}
	@Override
	
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return _listDataHeader.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Parent header = (Parent) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.parentitem, null);
        }
 
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.parentText);
        ImageView parentImageView = (ImageView)convertView.findViewById(R.id.parentImage);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(header.getText());
        parentImageView.setImageResource(header.getIcon());
 
        return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}
	
}

