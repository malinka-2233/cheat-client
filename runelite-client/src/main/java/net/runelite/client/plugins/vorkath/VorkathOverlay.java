package net.runelite.client.plugins.vorkath;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ImageUtil;

@Singleton
public class VorkathOverlay extends Overlay
{
	private static final Color COLOR_ICON_BACKGROUND = new Color(0, 0, 0, 128);
	private static final Color COLOR_ICON_BORDER = new Color(0, 0, 0, 255);
	private static final Color COLOR_ICON_BORDER_FILL = new Color(219, 175, 0, 255);
	private static final int OVERLAY_ICON_DISTANCE = 30;
	private static final int OVERLAY_ICON_MARGIN = 1;
	private static final BufferedImage UNKNOWN;
	private static final BufferedImage ACID;
	private static final BufferedImage FIRE_BALL;
	private static final BufferedImage SPAWN;

	static
	{
		UNKNOWN = ImageUtil.loadImageResource(VorkathPlugin.class, "magerange.png");
		ACID = ImageUtil.loadImageResource(VorkathPlugin.class, "acid.png");
		FIRE_BALL = ImageUtil.loadImageResource(VorkathPlugin.class, "fire_strike.png");
		SPAWN = ImageUtil.loadImageResource(VorkathPlugin.class, "ice.png");
	}

	private final Client client;
	private final VorkathPlugin plugin;
	private final VorkathConfig config;

	@Inject
	public VorkathOverlay(final Client client, final VorkathPlugin plugin, final VorkathConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getVorkath() != null)
		{
			final Vorkath vorkath = plugin.getVorkath();

			final LocalPoint localLocation = vorkath.getVorkath().getLocalLocation();
			if (localLocation != null)
			{
				Point point = Perspective.localToCanvas(client, localLocation, client.getPlane(), vorkath.getVorkath().getLogicalHeight() + 16);
				if (point != null)
				{
					point = new Point(point.getX(), point.getY());

					final BufferedImage currentPhaseIcon = getIcon(vorkath);

					int totalWidth = 0;
					if (currentPhaseIcon != null)
					{
						totalWidth = currentPhaseIcon.getWidth() * OVERLAY_ICON_MARGIN;
					}
					int bgPadding = 8;
					int currentPosX = 0;

					if (currentPhaseIcon == null)
					{
						return null;
					}

					setProgressIcon(graphics, point, currentPhaseIcon, totalWidth, bgPadding, currentPosX,
						COLOR_ICON_BACKGROUND, OVERLAY_ICON_DISTANCE, COLOR_ICON_BORDER, COLOR_ICON_BORDER_FILL);

					final Arc2D.Double arc = new Arc2D.Double(
						point.getX() - totalWidth / 2 + currentPosX - bgPadding,
						point.getY() - (float) (currentPhaseIcon.getHeight() / 2) - OVERLAY_ICON_DISTANCE - bgPadding,
						currentPhaseIcon.getWidth() + bgPadding * 2,
						currentPhaseIcon.getHeight() + bgPadding * 2,
						90.0,
						-360.0 * getAttacksLeftProgress(),
						Arc2D.OPEN
					);
					graphics.draw(arc);
				}
			}
		}

		if (plugin.getZombifiedSpawn() != null)
		{
			OverlayUtil.renderActorOverlayImage(graphics, plugin.getZombifiedSpawn(), SPAWN, Color.green, 10);
		}

		return null;
	}

	/**
	 * @param vorkath Vorkath object
	 * @return image of the current phase Vorkath is on
	 */
	private BufferedImage getIcon(Vorkath vorkath)
	{
		switch (vorkath.getCurrentPhase())
		{
			case UNKNOWN:
				return UNKNOWN;
			case ACID:
				return ACID;
			case FIRE_BALL:
				return FIRE_BALL;
			case SPAWN:
				return SPAWN;
		}
		return null;
	}

	/**
	 * @return number of attacks Vorkath has left in the current phase
	 */
	private double getAttacksLeftProgress()
	{
		if (plugin.getVorkath().getCurrentPhase() != Vorkath.Phase.FIRE_BALL)
		{
			return (double) (Vorkath.ATTACKS_PER_SWITCH - plugin.getVorkath().getAttacksLeft()) / Vorkath.ATTACKS_PER_SWITCH;
		}
		else
		{
			return (double) (Vorkath.FIRE_BALL_ATTACKS - plugin.getVorkath().getAttacksLeft()) / Vorkath.FIRE_BALL_ATTACKS;
		}
	}

	public static void setProgressIcon(Graphics2D graphics, Point point, BufferedImage currentPhaseIcon, int totalWidth, int bgPadding, int currentPosX, Color colorIconBackground, int overlayIconDistance, Color colorIconBorder, Color colorIconBorderFill)
	{
		graphics.setStroke(new BasicStroke(2));
		graphics.setColor(colorIconBackground);
		graphics.fillOval(
			point.getX() - totalWidth / 2 + currentPosX - bgPadding,
			point.getY() - currentPhaseIcon.getHeight() / 2 - overlayIconDistance - bgPadding,
			currentPhaseIcon.getWidth() + bgPadding * 2,
			currentPhaseIcon.getHeight() + bgPadding * 2);

		graphics.setColor(colorIconBorder);
		graphics.drawOval(
			point.getX() - totalWidth / 2 + currentPosX - bgPadding,
			point.getY() - currentPhaseIcon.getHeight() / 2 - overlayIconDistance - bgPadding,
			currentPhaseIcon.getWidth() + bgPadding * 2,
			currentPhaseIcon.getHeight() + bgPadding * 2);

		graphics.drawImage(
			currentPhaseIcon,
			point.getX() - totalWidth / 2 + currentPosX,
			point.getY() - currentPhaseIcon.getHeight() / 2 - overlayIconDistance,
			null);

		graphics.setColor(colorIconBorderFill);
	}
}