import { NgModule } from '@angular/core';
import {NbCardModule, NbCheckboxModule, NbInputModule, NbMenuModule} from '@nebular/theme';
import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { PagesRoutingModule } from './pages-routing.module';
import {ReclamationComponent} from './reclamation/reclamation.component';
import { ParentsComponent } from './parents/parents.component';
import { KindergartenComponent } from './kindergarten/kindergarten.component';
import { AdministratorComponent } from './administrator/administrator.component';
import { SatisfactionComponent } from './satisfaction/satisfaction.component';
import { FeedbackEventsComponent } from './feedback-events/feedback-events.component';
import { FeedbackOffersComponent } from './feedback-offers/feedback-offers.component';
import { OffersComponent } from './offers/offers.component';
import { EventsComponent } from './events/events.component';




@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    NbMenuModule,
    NbCardModule,
    NbCheckboxModule,
    NbInputModule,
  ],
  declarations: [
    PagesComponent,
    ReclamationComponent,
    ParentsComponent,
    KindergartenComponent,
    AdministratorComponent,
    SatisfactionComponent,
    FeedbackEventsComponent,
    FeedbackOffersComponent,
    OffersComponent,
    EventsComponent,
  ],
})
export class PagesModule {
}
