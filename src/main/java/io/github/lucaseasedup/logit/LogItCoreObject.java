/*
 * LogItCoreObject.java
 *
 * Copyright (C) 2012-2014 LucasEasedUp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.lucaseasedup.logit;

import io.github.lucaseasedup.logit.account.AccountManager;
import io.github.lucaseasedup.logit.backup.BackupManager;
import io.github.lucaseasedup.logit.config.LogItConfiguration;
import io.github.lucaseasedup.logit.locale.LocaleManager;
import io.github.lucaseasedup.logit.mail.MailSender;
import io.github.lucaseasedup.logit.persistence.PersistenceManager;
import io.github.lucaseasedup.logit.session.SessionManager;
import io.github.lucaseasedup.logit.storage.Storage;
import java.io.File;
import java.util.logging.Level;

/**
 * Provides a convenient way for objects to interact with {@code LogItCore}.
 */
public abstract class LogItCoreObject
{
    /**
     * Constructs a new {@code LogItCoreObject}.
     * 
     * @throws IllegalStateException if no LogItCore instance could be found.
     */
    public LogItCoreObject()
    {
        core = LogItCore.getInstance();
        
        if (core == null)
        {
            throw new IllegalStateException("No LogItCore instance found.");
        }
    }
    
    protected final LogItCore getCore()
    {
        return core;
    }
    
    protected final LogItPlugin getPlugin()
    {
        return core.getPlugin();
    }
    
    protected final boolean isCoreStarted()
    {
        return core.isStarted();
    }
    
    protected final File getDataFolder()
    {
        return core.getPlugin().getDataFolder();
    }
    
    /**
     * Returns the {@code LogItConfiguration} instance.
     * 
     * @return the {@code LogItConfiguration} instance,
     *         or {@code null} if the config has not been loaded yet.
     */
    protected final LogItConfiguration getConfig()
    {
        if (!core.isConfigLoaded())
            return null;
        
        return core.getConfig();
    }
    
    protected final AccountManager getAccountManager()
    {
        return core.getAccountManager();
    }
    
    protected final Storage getAccountStorage()
    {
        return core.getAccountManager().getStorage();
    }
    
    protected final BackupManager getBackupManager()
    {
        return core.getBackupManager();
    }
    
    protected final SessionManager getSessionManager()
    {
        return core.getSessionManager();
    }
    
    protected final PersistenceManager getPersistenceManager()
    {
        return core.getPersistenceManager();
    }
    
    protected final MailSender getMailSender()
    {
        return core.getMailSender();
    }
    
    protected final LocaleManager getLocaleManager()
    {
        return core.getLocaleManager();
    }
    
    protected final void log(Level level, String msg)
    {
        core.log(level, msg);
    }
    
    protected final void log(Level level, String msg, Throwable throwable)
    {
        core.log(level, msg, throwable);
    }
    
    protected final void log(Level level, Throwable throwable)
    {
        core.log(level, throwable);
    }
    
    protected final File getDataFile(String path)
    {
        return core.getDataFile(path);
    }
    
    private final LogItCore core;
}
