/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.barbarianassault;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.widgets.WidgetInfo;

@AllArgsConstructor
@Getter
enum Role
{
	ATTACKER(WidgetInfo.BA_ATK_ROLE_TEXT, WidgetInfo.BA_ATK_ROLE_SPRITE, WidgetInfo.BA_ATK_CALL_TEXT),
	DEFENDER(WidgetInfo.BA_DEF_ROLE_TEXT, WidgetInfo.BA_DEF_ROLE_SPRITE, WidgetInfo.BA_DEF_CALL_TEXT),
	COLLECTOR(WidgetInfo.BA_COLL_ROLE_TEXT, WidgetInfo.BA_COLL_ROLE_SPRITE, WidgetInfo.BA_COLL_CALL_TEXT),
	HEALER(WidgetInfo.BA_HEAL_ROLE_TEXT, WidgetInfo.BA_HEAL_ROLE_SPRITE, WidgetInfo.BA_HEAL_CALL_TEXT);

	private final WidgetInfo roleText;
	private final WidgetInfo roleSprite;
	private final WidgetInfo call;

	@Override
	public String toString()
	{
		return name();
	}
}
