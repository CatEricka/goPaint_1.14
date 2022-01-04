/*
 *                             _____      _       _
 *                            |  __ \    (_)     | |
 *                  __ _  ___ | |__) |_ _ _ _ __ | |_
 *                 / _` |/ _ \|  ___/ _` | | '_ \| __|
 *                | (_| | (_) | |  | (_| | | | | | |_
 *                 \__, |\___/|_|   \__,_|_|_| |_|\__|
 *                  __/ |
 *                 |___/
 *
 *    goPaint is designed to simplify painting inside of Minecraft.
 *                     Copyright (C) 2021 Arcaniax
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package net.arcaniax.gopaint.utils;

import net.arcaniax.gopaint.GoPaintPlugin;
import net.arcaniax.gopaint.objects.brush.AngleBrush;
import net.arcaniax.gopaint.objects.brush.Brush;
import net.arcaniax.gopaint.objects.brush.BucketBrush;
import net.arcaniax.gopaint.objects.brush.DiscBrush;
import net.arcaniax.gopaint.objects.brush.FractureBrush;
import net.arcaniax.gopaint.objects.brush.GradientBrush;
import net.arcaniax.gopaint.objects.brush.OverlayBrush;
import net.arcaniax.gopaint.objects.brush.PaintBrush;
import net.arcaniax.gopaint.objects.brush.SphereBrush;
import net.arcaniax.gopaint.objects.brush.SplatterBrush;
import net.arcaniax.gopaint.objects.brush.SprayBrush;
import net.arcaniax.gopaint.objects.other.BlockType;
import net.arcaniax.gopaint.objects.player.PlayerBrush;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class GUI {

    private static final String headSphere = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmU5OGY0ODU2MDE0N2MwYTJkNGVkYzE3ZjZkOTg1ZThlYjVkOTRiZDcyZmM2MDc0NGE1YThmMmQ5MDVhMTgifX19";
    private static final String headSpray = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjg4MGY3NjVlYTgwZGVlMzcwODJkY2RmZDk4MTJlZTM2ZmRhODg0ODY5MmE4NDFiZWMxYmJkOWVkNTFiYTIyIn19fQ==";
    private static final String headSplatter = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzMzODI5MmUyZTY5ZjA5MDY5NGNlZjY3MmJiNzZmMWQ4Mzc1OGQxMjc0NGJiNmZmYzY4MzRmZGJjMWE5ODMifX19";
    private static final String headDisc = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjFmMjgyNTBkMWU0MjBhNjUxMWIwMzk2NDg2OGZjYTJmNTYzN2UzYWJhNzlmNGExNjNmNGE4ZDYxM2JlIn19fQ==";
    private static final String headBucket = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTAxOGI0NTc0OTM5Nzg4YTJhZDU1NTJiOTEyZDY3ODEwNjk4ODhjNTEyMzRhNGExM2VhZGI3ZDRjOTc5YzkzIn19fQ==";
    private static final String headAngle = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRlNDQ4ZjBkYmU3NmJiOGE4MzJjOGYzYjJhMDNkMzViZDRlMjc4NWZhNWU4Mjk4YzI2MTU1MDNmNDdmZmEyIn19fQ==";
    private static final String headOverlay = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGYzMWQ2Zjk2NTRmODc0ZWE5MDk3YWRlZWEwYzk2OTk2ZTc4ZTNmZDM3NTRmYmY5ZWJlOTYzYWRhZDliZTRjIn19fQ==";
    private static final String headFracture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjNkZjczZWVlNjIyNGM1YzVkOTQ4ZDJhMzQ1ZGUyNWYyMDhjYmQ5YWY3MTA4Y2UxZTFiNjFhNTg2ZGU5OGIyIn19fQ==";
    private static final String headGradient = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjA2MmRhM2QzYjhmMWZkMzUzNDNjYzI3OWZiMGZlNWNmNGE1N2I1YWJjNDMxZmJiNzhhNzNiZjJhZjY3NGYifX19";
    private static final String headPaint = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODBiM2E5ZGZhYmVmYmRkOTQ5YjIxN2JiZDRmYTlhNDg2YmQwYzNmMGNhYjBkMGI5ZGZhMjRjMzMyZGQzZTM0MiJ9fX0=";
    private static final String headBlend = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWU5MTg0YWYxZGU3ZTViN2M0YWQ0MTFjNTZhZjRmOTMzNjY1MzYxNTkyOWJjOTVkNzEzYjdhNDJjZmYzZmJhZCJ9fX0=";

    public static Inventory Generate(PlayerBrush pb) {
        Inventory inv = Bukkit.createInventory(null, 54, "§1goPaint菜单");
        Update(inv, pb);
        return inv;
    }

    public static Inventory GenerateBrushes() {
        Inventory inv = Bukkit.createInventory(null, 27, "§1goPaint笔刷");
        Items item = new Items();
        // FILLER
        for (int x = 0; x < 27; x++) {
            inv.setItem(
                    x,
                    item.create(XMaterial.GRAY_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.GRAY_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }
        int x = 0;
        for (Brush b : GoPaintPlugin.getBrushManager().getBrushes()) {
            if (b instanceof SphereBrush) {
                inv.setItem(
                        x,
                        item.createHead(headSphere,
                                1,
                                "&6" + b.getName(),
                                "___&7单击选择______" + "&8常规球形笔刷"
                        )
                );
            } else if (b instanceof SprayBrush) {
                inv.setItem(
                        x,
                        item.createHead(headSpray,
                                1,
                                "&6" + b.getName(),
                                "___&7单击选择______" + "&8可配置着色密度的喷枪笔刷"
                        )
                );
            } else if (b instanceof SplatterBrush) {
                inv.setItem(
                        x,
                        item.createHead(headSplatter,
                                1,
                                "&6" + b.getName(),
                                "___&7单击选择______" + "&8越靠近中心___&8着色密度越大___&8可配置浓度"
                        )
                );
            } else if (b instanceof DiscBrush) {
                inv.setItem(
                        x,
                        item.createHead(headDisc,
                                1,
                                "&6" + b.getName(),
                                "___&7单击选择______" + "&8只在选定的轴向着色"
                        )
                );
            } else if (b instanceof BucketBrush) {
                inv.setItem(
                        x,
                        item.createHead(headBucket,
                                1,
                                "&6" + b.getName(),
                                "___&7单击选择______" + "&8只着色相连的块"
                        )
                );
            } else if (b instanceof AngleBrush) {
                inv.setItem(
                        x,
                        item.createHead(headAngle, 1, "&6" + b.getName(), "___&7单击选择______" + "&8只对山体有效")
                );
            } else if (b instanceof OverlayBrush) {
                inv.setItem(
                        x,
                        item.createHead(headOverlay,
                                1,
                                "&6" + b.getName(),
                                "___&7单击选择______" + "&8只对上面为空气的块着色"
                        )
                );
            } else if (b instanceof FractureBrush) {
                inv.setItem(
                        x,
                        item.createHead(headFracture,
                                1,
                                "&6" + b.getName(),
                                "___&7单击选择______" + "&8在裂缝和缺口处着色"
                        )
                );
            } else if (b instanceof GradientBrush) {
                inv.setItem(
                        x,
                        item.createHead(headGradient, 1, "&6" + b.getName(), "___&7单击选择______" + "&8渐变着色")
                );
            } else if (b instanceof PaintBrush) {
                inv.setItem(
                        x,
                        item.createHead(headPaint,
                                1,
                                "&6" + b.getName(),
                                "___&7单击选择______" + "&8油画笔触___&8右击创建路径___&8按住Shift右击结束"
                        )
                );
            }
            x++;
        }
        return inv;
    }

    public static void Update(Inventory inv, PlayerBrush pb) {
        Items item = new Items();
        Brush b = pb.getBrush();

        // FILLER
        for (int x = 0; x < 54; x++) {
            inv.setItem(
                    x,
                    item.create(XMaterial.GRAY_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.GRAY_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // goPaint toggle
        if (pb.isEnabled()) {
            inv.setItem(
                    1,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    10,
                    item.create(Material.FEATHER,
                            (short) 0,
                            1,
                            "&6goPaint Brush",
                            "&a&l已启用______&7拿起物品在此处单击可绑定笔刷___&7___&7右击禁用goPaint"
                    )
            );
            inv.setItem(
                    19,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        } else {
            inv.setItem(
                    1,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    10,
                    item.create(Material.FEATHER,
                            (short) 0,
                            1,
                            "&6goPaint Brush",
                            "&c&l已禁用______&7拿起物品在此处单击可绑定笔刷___&7___&7右击启用goPaint"
                    )
            );
            inv.setItem(
                    19,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // Brushes + Chance
        inv.setItem(
                2,
                item.create(XMaterial.ORANGE_STAINED_GLASS_PANE.parseMaterial(),
                        (short) XMaterial.ORANGE_STAINED_GLASS_PANE.data,
                        1,
                        "&7",
                        ""
                )
        );


        String clicks = "___&7按住Shift单击___&7  进入笔刷列表查看详细信息___&7单击或右击循环切换______";
        if (b instanceof SphereBrush) {
            inv.setItem(
                    11,
                    item.createHead(headSphere,
                            1,
                            "&6选定的笔刷类型",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof SprayBrush) {
            inv.setItem(
                    11,
                    item.createHead(headSpray,
                            1,
                            "&6选定的笔刷类型",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof SplatterBrush) {
            inv.setItem(
                    11,
                    item.createHead(headSplatter,
                            1,
                            "&6选定的笔刷类型",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof DiscBrush) {
            inv.setItem(
                    11,
                    item.createHead(headDisc,
                            1,
                            "&6选定的笔刷类型",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof BucketBrush) {
            inv.setItem(
                    11,
                    item.createHead(headBucket,
                            1,
                            "&6选定的笔刷类型",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof AngleBrush) {
            inv.setItem(
                    11,
                    item.createHead(headAngle,
                            1,
                            "&6选定的笔刷类型",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof OverlayBrush) {
            inv.setItem(
                    11,
                    item.createHead(headOverlay,
                            1,
                            "&6选定的笔刷类型",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof FractureBrush) {
            inv.setItem(
                    11,
                    item.createHead(headFracture,
                            1,
                            "&6选定的笔刷类型",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof GradientBrush) {
            inv.setItem(
                    11,
                    item.createHead(headGradient,
                            1,
                            "&6选定的笔刷类型",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        } else if (b instanceof PaintBrush) {
            inv.setItem(
                    11,
                    item.createHead(headPaint,
                            1,
                            "&6选定的笔刷类型",
                            clicks + GoPaintPlugin.getBrushManager().getBrushLore(b.getName())
                    )
            );
        }
        inv.setItem(
                20,
                item.create(XMaterial.ORANGE_STAINED_GLASS_PANE.parseMaterial(),
                        (short) XMaterial.ORANGE_STAINED_GLASS_PANE.data,
                        1,
                        "&7",
                        ""
                )
        );

        // chance
        if (b instanceof SprayBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.GOLD_NUGGET.parseMaterial(),
                            (short) 0,
                            1,
                            "&6着色密度: &e" + pb.getChance() + "%",
                            "___&7单击增加___&7右击减少"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // axis
        if (b instanceof DiscBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.COMPASS.parseMaterial(),
                            (short) 0,
                            1,
                            "&6轴向: &e" + pb.getAxis(),
                            "___&7点击修改"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }


        // thickness
        if (b instanceof OverlayBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.BOOK.parseMaterial(),
                            (short) 0,
                            1,
                            "&6向下着色深度: &e" + pb.getThickness(),
                            "___&7单击增大___&7右击减小"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // angle settings
        if (b instanceof AngleBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.DAYLIGHT_DETECTOR.parseMaterial(),
                            (short) 0,
                            1,
                            "&6角度检查距离: &e" + pb.getAngleDistance(),
                            "___&7单击增大___&7右击减小"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );

            inv.setItem(
                    4,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    13,
                    item.create(XMaterial.BLAZE_ROD.parseMaterial(),
                            (short) 0,
                            1,
                            "&6最大角度: &e" + pb.getMinHeightDifference() + "°",
                            "___&7角度指与水平的角度___&7只着色表面角度小于该角度的方块___&7___&7单击增大___&7右击减小___&7按住Shift点击增大或减小15"
                    )
            );
            inv.setItem(
                    22,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // fracture settings
        if (b instanceof FractureBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.DAYLIGHT_DETECTOR.parseMaterial(),
                            (short) 0,
                            1,
                            "&6裂缝检查距离: &e" + pb.getFractureDistance(),
                            "___&7单击增大___&7右击减小"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // angle settings
        if (b instanceof GradientBrush) {
            inv.setItem(
                    4,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    13,
                    item.create(XMaterial.MAGMA_CREAM.parseMaterial(),
                            (short) 0,
                            1,
                            "&6混合强度: &e" + pb.getMixingStrength() + "%",
                            "___&7单击增大___&7右击减小"
                    )
            );
            inv.setItem(
                    22,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        if (b instanceof SplatterBrush || b instanceof PaintBrush || b instanceof GradientBrush) {
            inv.setItem(
                    3,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    12,
                    item.create(XMaterial.BLAZE_POWDER.parseMaterial(),
                            (short) 0,
                            1,
                            "&6衰减强度: &e" + pb.getFalloffStrength() + "%",
                            "___&7单击增大___&7右击减小"
                    )
            );
            inv.setItem(
                    21,
                    item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }


        // Size
        inv.setItem(
                5,
                item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                        (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                        1,
                        "&7",
                        ""
                )
        );
        inv.setItem(
                14,
                item.create(XMaterial.BROWN_MUSHROOM.parseMaterial(),
                        (short) 0,
                        1,
                        "&6笔刷大小: &e" + pb.getBrushSize(),
                        "___&7单击增大___&7右击减小___&7按住Shift点击增加或减小10"
                )
        );
        inv.setItem(
                23,
                item.create(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial(),
                        (short) XMaterial.WHITE_STAINED_GLASS_PANE.data,
                        1,
                        "&7",
                        ""
                )
        );

        // Mask toggle
        if (pb.isMaskEnabled()) {
            inv.setItem(
                    6,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    15,
                    item.create(XMaterial.JACK_O_LANTERN.parseMaterial(),
                            (short) 0,
                            1,
                            "&6蒙版",
                            "&a&l已启用______&7点击禁用"
                    )
            );
            inv.setItem(
                    24,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        } else {
            inv.setItem(
                    6,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    15,
                    item.create(XMaterial.PUMPKIN.parseMaterial(), (short) 0, 1, "&6蒙版", "&c&l已禁用______&7点击启用")
            );
            inv.setItem(
                    24,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // Surface Mode toggle
        if (pb.isSurfaceModeEnabled()) {
            inv.setItem(
                    7,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    16,
                    item.create(XMaterial.LIGHT_WEIGHTED_PRESSURE_PLATE.parseMaterial(),
                            (short) 0,
                            1,
                            "&6表面模式",
                            "&a&l已开启______&7只对表面着色______&7点击关闭"
                    )
            );
            inv.setItem(
                    25,
                    item.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.LIME_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        } else {
            inv.setItem(
                    7,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
            inv.setItem(
                    16,
                    item.create(XMaterial.LIGHT_WEIGHTED_PRESSURE_PLATE.parseMaterial(),
                            (short) 0,
                            1,
                            "&6表面模式",
                            "&c&l已关闭______&7会对内部着色______&7点击开启"
                    )
            );
            inv.setItem(
                    25,
                    item.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.RED_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }

        // Place Block
        for (int x = 37; x <= 41; x++) {
            inv.setItem(
                    x,
                    item.create(XMaterial.YELLOW_STAINED_GLASS_PANE.parseMaterial(),
                            (short) XMaterial.YELLOW_STAINED_GLASS_PANE.data,
                            1,
                            "&7",
                            ""
                    )
            );
        }
        for (int x = 46; x <= 50; x++) {
            inv.setItem(
                    x,
                    item.create(XMaterial.BARRIER.parseMaterial(), (short) 0, 1, "&c空混色槽", "___&7放入方块设置")
            );
        }
        int x = 46;
        int size = pb.getBlocks().size();
        for (BlockType bt : pb.getBlocks()) {
            Material mat = bt.getMaterial();
            short data = bt.getData();
            int chance = (int) Math.floor(100 / size);
            if (chance > 64) {
                inv.setItem(
                        x,
                        item.create(mat,
                                data,
                                1,
                                "&a混色槽 " + (x - 45) + " &7" + (int) Math.floor(100 / size) + "%",
                                "___&7放入方块修改___&7右击清除"
                        )
                );
            } else {
                inv.setItem(
                        x,
                        item.create(mat,
                                data,
                                (int) Math.floor(100 / size),
                                "&a混色槽 " + (x - 45) + " &7" + (int) Math.floor(100 / size) + "%",
                                "___&7放入方块修改___&7右击清除"
                        )
                );
            }
            x++;
        }

        // Mask Block
        inv.setItem(
                43,
                item.create(XMaterial.YELLOW_STAINED_GLASS_PANE.parseMaterial(),
                        (short) XMaterial.YELLOW_STAINED_GLASS_PANE.data,
                        1,
                        "&7",
                        ""
                )
        );
        BlockType bt = pb.getMask();
        inv.setItem(
                52,
                item.create(bt.getMaterial(), bt.getData(), 1, "&6当前蒙版", "___&7放入方块修改蒙版")
        );
    }

}
