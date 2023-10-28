/*
 * Dungeons Guide - The most intelligent Hypixel Skyblock Dungeons Mod
 * Copyright (C) 2023  cyoung06 (syeyoung)
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

package kr.syeyoung.skyvelutter.elements.richtext.fonts;

import kr.syeyoung.dungeonsguide.mod.guiv2.elements.richtext.FlatTextSpan;
import kr.syeyoung.dungeonsguide.mod.guiv2.elements.richtext.styles.ITextStyle;

public interface FontRenderer {
    double getWidth(char text, ITextStyle textStyle);
    // from y 0 going downward
    double getBaselineHeight(ITextStyle textStyle);

    void render(FlatTextSpan lineElement, double x, double v, double currentScale);
}
