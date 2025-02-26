//-----------------------------------------------WITAJ---------------------------------------------------------------------------
//Poniższy plik został przygotowany, aby ułatwić Ci Twoją przygodę z tworzeniem modyfikacji. Zawiera on instrukcje związane
//nie bezpośrednio z ogólnym programowaniem, ale raczej kod dotyczący samego Minecrafta oraz, co bardzo ważne, MCreatora w wersji 
//2022.3! Traktuj go jako przybornik z narzędziami, z których w każdej chwili możesz skorzystać. 
//Pamiętaj o zamienianiu nazw zawartych w poleceniach na swoje własne!
//---------------------------------------------Powodzenia!-----------------------------------------------------------------------


//1. Odczytywanie bloku we współrzędnych (x, y, z).
/*-------------------------------------------------------------------------------------------------------------------------------
(world.getBlockState(new BlockPos(x, y, z))).getBlock()
*///-----------------------------------------------------------------------------------------------------------------------------


//2. Przywoływanie przedmiotu.
//W miejsce <NAZWA_PRZEDMIOTU> umieszczamy nazwę przedmiotu, który chcemy przywołać, np. APPLE.
/*-------------------------------------------------------------------------------------------------------------------------------
if (world instanceof Level _level && !_level.isClientSide()) {
	ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.<NAZWA_PRZEDMIOTU>));
	entityToSpawn.setPickUpDelay(10);
	_level.addFreshEntity(entityToSpawn);
}
*///-----------------------------------------------------------------------------------------------------------------------------


//3. Dostęp do zmiennej globalnej dla projektu.
//W przypadku tego projektu, którego nazwa to testBlock, wpisujemy Testblock. Zamieniamy nazwę projektu oraz zmiennej na własną.
/*-------------------------------------------------------------------------------------------------------------------------------
<Nazwaprojektu>ModVariables.MapVariables.get(world).<nazwaZmiennej>
*///-----------------------------------------------------------------------------------------------------------------------------


//4. Przywołanie stworzenia.
//Dwie nazwy do wstawienia: <Rodzaj> i <RODZAJ>. Dla większości przypadków różnić się będą wielkością liter. np. Zombie i ZOMBIE.
/*-------------------------------------------------------------------------------------------------------------------------------
if (world instanceof ServerLevel _level) {
	Entity entityToSpawn = new <Rodzaj>(EntityType.<RODZAJ>, (Level) world);
	entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
	if (entityToSpawn instanceof Mob _mobToSpawn)
	_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
	null);
	world.addFreshEntity(entityToSpawn);
}
*///-----------------------------------------------------------------------------------------------------------------------------


//5. Ustawianie bloku.
//Zamieniamy <NAZWA_BLOKU> na wybraną nazwę bloku, pisaną wielkimi literami. Np. GRAVEL, aby przywołać żwir.
/*-------------------------------------------------------------------------------------------------------------------------------
world.setBlock(new BlockPos(x, y, z), Blocks.<NAZWA_BLOKU>.defaultBlockState(), 3);
*///-----------------------------------------------------------------------------------------------------------------------------


//6. Odczytanie wysokości bloku na powierzchni świata w danym miejscu.
/*-------------------------------------------------------------------------------------------------------------------------------
world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z);
*///-----------------------------------------------------------------------------------------------------------------------------


//7. Użycie mączki kostnej w danym miejscu.
/*-------------------------------------------------------------------------------------------------------------------------------
if (world instanceof Level _level) {
	BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, new BlockPos(x, y, z));
}
*///-----------------------------------------------------------------------------------------------------------------------------


//8. Odczytywanie współrzędnych stworzenia.
//W podobny sposób można odczytywać wiele informacji o stworzeniu lub używać na nim metod.
/*-------------------------------------------------------------------------------------------------------------------------------
entity.getX();
entity.getY();
entity.getZ();
*///-----------------------------------------------------------------------------------------------------------------------------


//9. Odczytywanie toru ruchu stworzenia/bytu.
/*-------------------------------------------------------------------------------------------------------------------------------
entity.getDeltaMovement()
*///-----------------------------------------------------------------------------------------------------------------------------


//10. Sprawdzanie, czy byt będący graczem ma w ekwipunku przedmiot.
//W miejsce <przedmiot/blok> wstawiamy Block.<NAZWA_BLOKU> lub Item.<NAZWA_PRZEDMIOTU>.
/*-------------------------------------------------------------------------------------------------------------------------------
((Player) entity).getInventory().contains(new ItemStack(<przedmiot/blok>))
*///-----------------------------------------------------------------------------------------------------------------------------


//11. Wysyłanie wiadomości do gracza.
//W miejsce <WIADOMOŚĆ> wstawiamy dowolny komunikat. Musi on znajdować się w cudzysłowie.
/*-------------------------------------------------------------------------------------------------------------------------------
if (entity instanceof Player _player && !_player.level.isClientSide())
	_player.displayClientMessage(Component.literal("<WIADOMOŚĆ>"), (false));
*///-----------------------------------------------------------------------------------------------------------------------------


//12. Sprawdzenie, czy gracz ma założony konkretny napierśnik.
//Wstawiamy w miejsce <przedmiot/block> Block.<NAZWA_BLOKU> lub Item.<NAZWA_PRZEDMIOTU>.
//W przypadku tego projektu, którego nazwa to testBlock, wpisujemy Testblock w <Nazwaprojektu> lub własną nazwę.
//W miejsce <NAZWA_PANCERZA> wpisujemy własną nazwę pancerza wielkimi literami, oddzielając kolejne słowa podkreślnikiem.
/*-------------------------------------------------------------------------------------------------------------------------------
player.getItemBySlot(EquipmentSlot.CHEST).getItem() == <Nazwaprojektu>ModItems.<NAZWA_PANCERZA>_ARMOR_CHESTPLATE.get()
*///-----------------------------------------------------------------------------------------------------------------------------


//13. Tworzenie nowego efektu.
//W miejsce <NAZWA_EFEKTU> wpisujemy nazwę wielkimi literami, np. MOVEMENT_SPEED. Czas trwania efektu podajemy w tickach (liczba).
//Siłę efektu określamy liczbą w zakresie od 0 do maksymalnie 255.
/*-------------------------------------------------------------------------------------------------------------------------------
MobEffectInstance mobEffInst = new MobEffectInstance(MobEffects.<NAZWA_EFEKTU>, <CZAS_TRWANIA_W_TICKACH>, <SIŁA_EFEKTU>);
*///-----------------------------------------------------------------------------------------------------------------------------

