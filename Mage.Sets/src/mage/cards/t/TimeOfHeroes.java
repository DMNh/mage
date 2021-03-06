
package mage.cards.t;

import java.util.UUID;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.ContinuousEffect;
import mage.abilities.effects.common.continuous.BoostAllEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.counters.CounterType;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.permanent.CounterPredicate;

/**
 *
 * @author jeffwadsworth
 */
public final class TimeOfHeroes extends CardImpl {
    
    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("Each creature you control with a level counter");
    
    static {
        filter.add(TargetController.YOU.getControllerPredicate());
        filter.add(new CounterPredicate(CounterType.LEVEL));
    }

    public TimeOfHeroes(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ENCHANTMENT},"{1}{W}");


        // Each creature you control with a level counter on it gets +2/+2.
        ContinuousEffect boost = new BoostAllEffect(2, 2, Duration.WhileOnBattlefield, filter, false);
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, boost));
    }

    public TimeOfHeroes(final TimeOfHeroes card) {
        super(card);
    }

    @Override
    public TimeOfHeroes copy() {
        return new TimeOfHeroes(this);
    }
}
