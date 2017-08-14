<div>
User View: <br>
	<div style="display: table">
		<div style="display: table-row;">
			<div style="display: table-cell;text-align: right;">
				<md-button class="md-button md-raised md-primary button-override" ng-click="vm.showDialog($event, 0)">add new</md-button>
			</div>			
		</div>
		<div style="display: table-row;">
			<div style="display: table-cell">
				<table class="data-tbl">
					<tr>
						<td>Username</td>
						<td>Email</td>
						<td>Created By</td>
						<td>Date Created</td>
						<td>Updated By</td>
						<td>Date Updated</td>
					</tr>
					<tr ng-repeat="u in vm.users" 
						ng-dblclick="vm.showDialog($event, u.userId)" 
						title="Double click to view details..." 
						id="repeat-data">
						<td>{{u.username}}</td>
						<td>{{u.email}}</td>
						<td>{{u.createdBy}}</td>
						<td>{{u.dateCreated | date: 'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{u.updatedBy}}</td>
						<td>{{u.dateUpdated | date: 'yyyy-MM-dd HH:mm:ss'}}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>