/*
 * Dungeons Guide - The most intelligent Hypixel Skyblock Dungeons Mod
 * Copyright (C) 2022  cyoung06 (syeyoung)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package kr.syeyoung.skyvelutter.layouter;

import kr.syeyoung.skyvelutter.DomElement;
import kr.syeyoung.skyvelutter.primitive.ConstraintBox;
import kr.syeyoung.skyvelutter.primitive.Rect;
import kr.syeyoung.skyvelutter.primitive.Size;

public class SingleChildPassingLayouter implements Layouter {
    public static final SingleChildPassingLayouter INSTANCE = new SingleChildPassingLayouter();
    private SingleChildPassingLayouter() {}

    @Override
    public Size layout(DomElement buildContext, ConstraintBox constraintBox) {
        if (buildContext.getChildren().isEmpty()) {
            return new Size(constraintBox.getMaxWidth() == Double.POSITIVE_INFINITY ? 0  : constraintBox.getMaxWidth(),
                    constraintBox.getMaxHeight() == Double.POSITIVE_INFINITY ? 0 : constraintBox.getMaxHeight());
        }

        DomElement childCtx = buildContext.getChildren().get(0);

        Size dim = childCtx.getLayouter().layout(childCtx, constraintBox);
        childCtx.setRelativeBound(new Rect(0,0, dim.getWidth(), dim.getHeight()));
        return new Size(dim.getWidth(), dim.getHeight());
    }


    @Override
    public double getMaxIntrinsicWidth(DomElement buildContext, double height) {
        return buildContext.getChildren().isEmpty() ? 0 : buildContext.getChildren().get(0).getLayouter().getMaxIntrinsicWidth(buildContext.getChildren().get(0), height);
    }

    @Override
    public double getMaxIntrinsicHeight(DomElement buildContext, double width) {
        return buildContext.getChildren().isEmpty() ? 0 : buildContext.getChildren().get(0).getLayouter().getMaxIntrinsicHeight(buildContext.getChildren().get(0), width);
    }
}
