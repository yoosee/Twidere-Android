/*
 * 				Twidere - Twitter client for Android
 * 
 *  Copyright (C) 2012-2014 Mariotaku Lee <mariotaku.lee@gmail.com>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mariotaku.twidere.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class SquareViewPager extends ViewPager {

    public SquareViewPager(final Context context) {
        super(context);
    }

    public SquareViewPager(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        final int width = MeasureSpec.getSize(widthMeasureSpec), height = MeasureSpec.getSize(heightMeasureSpec);
        final ViewGroup.LayoutParams lp = getLayoutParams();
        if (lp.height == ViewGroup.LayoutParams.MATCH_PARENT && lp.width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            super.onMeasure(heightMeasureSpec, heightMeasureSpec);
            setMeasuredDimension(height, height);
        } else if (lp.width == ViewGroup.LayoutParams.MATCH_PARENT && lp.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            super.onMeasure(widthMeasureSpec, widthMeasureSpec);
            setMeasuredDimension(width, width);
        } else {
            if (width > height) {
                super.onMeasure(heightMeasureSpec, heightMeasureSpec);
                setMeasuredDimension(height, height);
            } else {
                super.onMeasure(widthMeasureSpec, widthMeasureSpec);
                setMeasuredDimension(width, width);
            }
        }
    }

}
