package net.labymod.serverapi.common;

import net.labymod.serverapi.api.LabyService;
import net.labymod.serverapi.api.discord.RichPresenceTransmitter;
import net.labymod.serverapi.api.emote.EmoteTransmitter;
import net.labymod.serverapi.api.extension.AddonExtension;
import net.labymod.serverapi.api.extension.ExtensionCollector;
import net.labymod.serverapi.api.extension.ModificationExtension;
import net.labymod.serverapi.api.extension.PackageExtension;
import net.labymod.serverapi.api.permission.PermissionService;
import net.labymod.serverapi.api.protocol.ChunkCachingProtocol;
import net.labymod.serverapi.api.protocol.ShadowProtocol;
import net.labymod.serverapi.api.serverinteraction.CineScopes;
import net.labymod.serverapi.api.serverinteraction.ServerSwitcher;
import net.labymod.serverapi.api.serverinteraction.TabListCache;
import net.labymod.serverapi.api.serverinteraction.Watermark;
import net.labymod.serverapi.api.serverinteraction.actionmenu.Menu;
import net.labymod.serverapi.api.serverinteraction.economy.EconomyDisplay;
import net.labymod.serverapi.api.serverinteraction.gui.InputPromptTransmitter;
import net.labymod.serverapi.api.serverinteraction.subtile.SubTitle;
import net.labymod.serverapi.api.serverinteraction.subtile.SubTitleTransmitter;
import net.labymod.serverapi.api.sticker.Sticker;
import net.labymod.serverapi.api.sticker.Sticker.Factory;
import net.labymod.serverapi.api.sticker.StickerTransmitter;
import net.labymod.serverapi.common.discord.DefaultRichPresenceTransmitter;
import net.labymod.serverapi.common.emote.DefaultEmoteTransmitter;
import net.labymod.serverapi.common.extension.DefaultAddonExtensionCollector;
import net.labymod.serverapi.common.extension.DefaultModificationExtensionCollector;
import net.labymod.serverapi.common.extension.DefaultPackageExtensionCollector;
import net.labymod.serverapi.common.permission.DefaultPermissionService;
import net.labymod.serverapi.common.protocol.DefaultChunkCachingProtocolFactory;
import net.labymod.serverapi.common.protocol.DefaultShadowProtocolFactory;
import net.labymod.serverapi.common.serverinteraction.DefaultCineScopes;
import net.labymod.serverapi.common.serverinteraction.DefaultServerSwitcher;
import net.labymod.serverapi.common.serverinteraction.DefaultTabListCache;
import net.labymod.serverapi.common.serverinteraction.DefaultWatermark;
import net.labymod.serverapi.common.serverinteraction.actionmenu.DefaultMenu;
import net.labymod.serverapi.common.serverinteraction.economy.DefaultEconomyDisplay;
import net.labymod.serverapi.common.serverinteraction.gui.DefaultInputPromptTransmitter;
import net.labymod.serverapi.common.serverinteraction.subtitle.DefaultSubTitleFactory;
import net.labymod.serverapi.common.serverinteraction.subtitle.DefaultSubTitleTransmitter;
import net.labymod.serverapi.common.sticker.DefaultStickerFactory;
import net.labymod.serverapi.common.sticker.DefaultStickerTransmitter;

public abstract class AbstractLabyService implements LabyService {

  private final CineScopes cineScopes;
  private final Menu menu;
  private final InputPromptTransmitter inputPromptTransmitter;
  private final EconomyDisplay economyDisplay;
  private final ServerSwitcher serverSwitcher;
  private final TabListCache tabListCache;
  private final Watermark watermark;

  private final EmoteTransmitter emoteTransmitter;
  private final RichPresenceTransmitter richPresenceTransmitter;
  private final PermissionService permissionService;

  private final ExtensionCollector<AddonExtension> addonExtensionCollector;
  private final ExtensionCollector<ModificationExtension> modificationExtensionCollector;
  private final ExtensionCollector<PackageExtension> packageExtensionCollector;

  private final ChunkCachingProtocol.Factory chunkCachingProtocolFactory;
  private final ShadowProtocol.Factory shadowProtocolFactory;

  // Sub titles
  private final SubTitle.Factory subTitleFactory;
  private final SubTitleTransmitter subTitleTransmitter;

  // Stickers
  private final Sticker.Factory stickerFactory;
  private final StickerTransmitter stickerTransmitter;

  protected AbstractLabyService() {
    this.cineScopes = new DefaultCineScopes(this);
    this.serverSwitcher = new DefaultServerSwitcher(this);
    this.tabListCache = new DefaultTabListCache(this);
    this.watermark = new DefaultWatermark(this);

    this.menu = new DefaultMenu(this);
    this.economyDisplay = new DefaultEconomyDisplay(this);
    this.inputPromptTransmitter = new DefaultInputPromptTransmitter(this);

    this.emoteTransmitter = new DefaultEmoteTransmitter(this);
    this.richPresenceTransmitter = new DefaultRichPresenceTransmitter(this);
    this.permissionService = new DefaultPermissionService(this);

    this.addonExtensionCollector = new DefaultAddonExtensionCollector();
    this.modificationExtensionCollector = new DefaultModificationExtensionCollector();
    this.packageExtensionCollector = new DefaultPackageExtensionCollector();

    this.chunkCachingProtocolFactory = new DefaultChunkCachingProtocolFactory();
    this.shadowProtocolFactory = new DefaultShadowProtocolFactory();

    this.subTitleFactory = new DefaultSubTitleFactory();
    this.subTitleTransmitter = new DefaultSubTitleTransmitter(this);

    this.stickerFactory = new DefaultStickerFactory();
    this.stickerTransmitter = new DefaultStickerTransmitter(this);
  }

  @Override
  public CineScopes getCineScopes() {
    return this.cineScopes;
  }

  @Override
  public RichPresenceTransmitter getRichPresenceTransmitter() {
    return this.richPresenceTransmitter;
  }

  @Override
  public EmoteTransmitter getEmoteTransmitter() {
    return this.emoteTransmitter;
  }

  @Override
  public ServerSwitcher getServerSwitcher() {
    return this.serverSwitcher;
  }

  @Override
  public ExtensionCollector<AddonExtension> getAddonExtensionCollector() {
    return this.addonExtensionCollector;
  }

  @Override
  public ExtensionCollector<ModificationExtension> getModificationExtensionCollector() {
    return this.modificationExtensionCollector;
  }

  @Override
  public ExtensionCollector<PackageExtension> getPackageExtensionCollector() {
    return this.packageExtensionCollector;
  }

  @Override
  public ChunkCachingProtocol.Factory getChunkCachingProtocolFactory() {
    return this.chunkCachingProtocolFactory;
  }

  @Override
  public ShadowProtocol.Factory getShadowProtocolFactory() {
    return this.shadowProtocolFactory;
  }

  @Override
  public TabListCache getTabListCache() {
    return this.tabListCache;
  }

  @Override
  public Watermark getWatermark() {
    return this.watermark;
  }

  @Override
  public PermissionService getPermissionService() {
    return this.permissionService;
  }

  @Override
  public Menu getMenu() {
    return this.menu;
  }

  @Override
  public EconomyDisplay getEconomyDisplay() {
    return this.economyDisplay;
  }

  @Override
  public InputPromptTransmitter getInputPromptTransmitter() {
    return this.inputPromptTransmitter;
  }

  @Override
  public SubTitle.Factory getSubTitleFactory() {
    return this.subTitleFactory;
  }

  @Override
  public SubTitleTransmitter getSubTitleTransmitter() {
    return this.subTitleTransmitter;
  }

  @Override
  public Factory getStickerFactory() {
    return this.stickerFactory;
  }

  @Override
  public StickerTransmitter getStickerTransmitter() {
    return this.stickerTransmitter;
  }
}
