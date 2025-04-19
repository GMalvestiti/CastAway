# CastAway

*CastAway* is a lightweight Minecraft mod for Fabric that prevents lava cast griefing by modifying the way **lava and water interact**. Specifically, it disables the automatic generation of cobblestone when lava meets water, thus breaking lava casts.

### Key Features:
- ❌ **Cobblestone** generators no longer work.
- ✅ **Stone** generators continue to function as usual.
- ✅ **Obsidian** generation continue to function as usual.
- ✅ Modded fluid interactions remain unaffected unless involving a lava or water variant.

*CastAway* is ideal for **servers** where lava casts are problematic, offering a seamless solution without performance penalties.

##  How Lava-Water Interactions Work (Vanilla)

In vanilla Minecraft, when lava and water come into contact, the resulting block depends on several factors:

1. The type of lava (**flowing or source**).
2. The type of water (**flowing or source**).
3. The **direction** of interaction.

### Interaction Table

| Interaction                             | Resulting Block | Affected by CastAway?        |
|----------------------------------------|------------------|------------------------------|
| Water → source lava       | Obsidian         | ❌ Unaffected                |
| Water → flowing lava    | Cobblestone      | ✅ Replaced with flowing water |
| Lava → water (**from above**) | Stone            | ❌ Unaffected                |
| Lava → water (others)   | Cobblestone      | ✅ Replaced with flowing water |

>  **CastAway intercepts the interaction** and replaces cobblestone with flowing water, preventing lava casts from forming while leaving other mechanics untouched.

## Installation

1. Drop the CastAway `.jar` into your `mods` folder.
2. Start the server or enter the world — the mod is active immediately.

> This mod operates **server-side only**, meaning clients do not need to install it.

## Compatibility and Performance

*CastAway* uses a **Mixin** to intercept the call that generates a new block when lava interacts with water. It modifies the `receiveNeighborFluids` method, which controls the formation of cobblestone during lava-water interactions.

```java
if (state.isOf(Blocks.COBBLESTONE)) {
    return world.setBlockState(pos, CastAway.FLOWING_WATER);
}
```

### ✅ Affected:
- **Vanilla lava and water**.
- **Modded fluids** tagged as `lava` or `water`.

### ❌ Not Affected:
- Fluids **not tagged** as lava or water (e.g., oil, molten metals, gases).
- Manual cobblestone placement or non-fluid generation mechanics.
- Custom fluid systems not using standard `FluidBlock` logic.

## Stone Generator (Working)

![Alternative/Working Stone Generator](https://cdn.modrinth.com/data/cached_images/e23f72c914b21b58dc1b14915c5a3d2cbd523ea5.png)
