import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import {ReclamationComponent} from './reclamation/reclamation.component';
import {SatisfactionComponent} from './satisfaction/satisfaction.component';
import {OffersComponent} from './offers/offers.component';
import {EventsComponent} from './events/events.component';
import {AdministratorComponent} from './administrator/administrator.component';
import {FeedbackEventsComponent} from './feedback-events/feedback-events.component';
import {FeedbackOffersComponent} from './feedback-offers/feedback-offers.component';
import {KindergartenComponent} from './kindergarten/kindergarten.component';
import {ParentsComponent} from './parents/parents.component';
import {ReclamationAdminComponent} from './administrator/reclamation-admin/reclamation-admin.component';
import {SatisfactionAdminComponent} from './administrator/satisfaction-admin/satisfaction-admin.component';
import {FeedbacksComponent} from './administrator/feedbacks/feedbacks.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path: 'reclamation-admin',
      component: ReclamationAdminComponent,
    },
    {
      path: 'satisfaction-admin',
      component: SatisfactionAdminComponent,
    },
    {
      path: 'feedbacks',
      component: FeedbacksComponent,
    },
    {
      path: 'administrator',
      component: AdministratorComponent,
    },
    {
      path: 'parents',
      component: ParentsComponent,
    },
    {
      path: 'kindergarten',
      component: KindergartenComponent,
    },
    {
      path: 'events',
      component: EventsComponent,
    },
    {
      path: 'feedbackEvents',
      component: FeedbackEventsComponent,
    },
    {
      path: 'Offers',
      component: OffersComponent,
    },
    {
      path: 'feedbackOffers',
      component: FeedbackOffersComponent,
    },
    {
      path: 'reclamation',
      component: ReclamationComponent,
    },
    {
      path: 'satisfaction',
      component: SatisfactionComponent,
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
