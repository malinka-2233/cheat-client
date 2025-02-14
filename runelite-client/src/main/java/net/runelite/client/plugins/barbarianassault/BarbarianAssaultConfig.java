/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("barbarianAssault")
public interface BarbarianAssaultConfig extends Config
{
	@ConfigItem(
		keyName = "removeUnused",
		name = "Remove incorrect calls",
		description = "Removes incorrect calls for Role horn"
	)
	default boolean removeWrong()
	{
		return true;
	}
	@ConfigItem(
		keyName = "showTimer",
		name = "Show call change timer",
		description = "Show time to next call change"
	)
	default boolean showTimer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showHealerBars",
		name = "Show health bars for teammates when healer",
		description = "Displays team health for healer"
	)
	default boolean showHealerBars()
	{
		return true;
	}

	@ConfigItem(
		keyName = "waveTimes",
		name = "Show wave and game duration",
		description = "Displays wave and game duration"
	)
	default boolean waveTimes()
	{
		return true;
	}
}
