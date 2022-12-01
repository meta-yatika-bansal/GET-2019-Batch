import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewTaskComponent } from './new-task/new-task.component';
import { AppComponent } from './app.component';
import { AllTodoComponent } from './all-todo/all-todo.component';
import { EditTaskComponent } from './edit-task/edit-task.component';
import { TaskDetailsComponent } from './task-details/task-details.component';


const routes: Routes = [
  { path: 'new-task', component: NewTaskComponent },
  { path: 'app-component', component: AppComponent },
  { path: 'my-task-tracker', component: AllTodoComponent},
  {path: 'edit-task/:date', component: EditTaskComponent },
  {path: 'task-details/:date', component: TaskDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
